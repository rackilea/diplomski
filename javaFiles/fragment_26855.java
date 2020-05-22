try{
        Connection response = Jsoup.connect("http://blahblahblah.com/site/Login/?domain=blahblahblah.com&request=abc123").method(Method.GET);
        response.ignoreHttpErrors(false);
        org.jsoup.Connection.Response r = response.execute();
    }
        catch (HttpStatusException e) {
//not throwed
    }