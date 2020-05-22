Pattern p2 = Pattern.compile("sig=(.*?)[&]");
        Matcher m2 = p2.matcher(url);
        String sig = null;
        if (m2.find()) {
            sig = m2.group(1);
        }