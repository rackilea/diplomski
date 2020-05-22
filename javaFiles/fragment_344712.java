String url = "www.google.com/{name}/{mobile}";
        UriTemplate template = new UriTemplate(url);
        Map<String, String> map = new HashMap<>();
        map.put("name", "#PCP");
        map.put("mobile", "123456789");
        URI uri = template.expand(map);
        System.out.println("uri=" + uri.getPath());