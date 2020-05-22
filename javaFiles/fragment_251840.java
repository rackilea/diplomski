MultipartEntity e = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
            e.addPart("part1", new StringBody("value1"));
            e.addPart("part2", new StringBody("value2"));

            HTTPRequest req = new HTTPRequest(new URL(myUrl), HTTPMethod.POST);
            ServletHelper.addMultipartBodyToRequest(e, req);

            URLFetchServiceFactory.getURLFetchService().fetchAsync(req);