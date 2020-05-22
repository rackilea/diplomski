@Override
public void add(URI uri, HttpCookie cookie) {
    // TODO Auto-generated method stub
    synchronized (this) {
        URI uri2 = createURI(uri);
        List<HttpCookie> cookies = mCookies.get(uri2);
        if (cookies == null) {
            cookies = new ArrayList<HttpCookie>();
            mCookies.put(uri2, cookies);
        } else {
            cookies.remove(cookie);
        }
        cookies.add(cookie);
        // Save into SharePreferenced
        saveToPersistent(uri2, cookies);
    }
}

@Override
public List<HttpCookie> get(URI uri) {
    // TODO Auto-generated method stub
    synchronized (this) {
        List<HttpCookie> httpCookies = new ArrayList<HttpCookie>();
        List<HttpCookie> values = mCookies.get(uri);
        if (values != null) {
            for (HttpCookie httpCookie : values) {
                if (!httpCookie.hasExpired()) {
                    httpCookies.add(httpCookie);
                }
            }
        }

        Set<Entry<URI, List<HttpCookie>>> set = mCookies.entrySet();
        for (Entry<URI, List<HttpCookie>> entry : set) {
            if (uri.equals(entry.getKey())) {
                continue;
            }
            List<HttpCookie> cookies = entry.getValue();
            Iterator<HttpCookie> iterator = cookies.iterator();
            while (iterator.hasNext()) {
                HttpCookie cookie = iterator.next();
                String domain = cookie.getDomain();
                if (!domainMatches(domain, uri.getHost())) {
                    continue;
                }
                if (cookie.hasExpired()) {
                    iterator.remove();
                } else if (!httpCookies.contains(cookie)) {
                    httpCookies.add(cookie);
                }
            }
        }
        return Collections.unmodifiableList(httpCookies);
    }
}