try {
        String s = "http://admin.biin.net:8289/project.do?cmd=AddProject&mode=default&projectFieldValueJSON=" 
                    + URLEncoder.encode("{\"fieldIds\":[{\"id\":1360,\"value\":\"project SS33\"},{\"id\":1362,\"value\":\"12/03/2015\"},{\"id\":1363,\"value\":\"12/31/2015\"}],\"state\":1}", "UTF-8") 
                    + "&jsessionid=AE5B03C9791D1019DCD7BBF0E34CCFEE";
        System.out.println(s);
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

Result: http://admin.biin.net:8289/project.do?cmd=AddProject&mode=default&projectFieldValueJSON=%7B%22fieldIds%22%3A%5B%7B%22id%22%3A1360%2C%22value%22%3A%22project+SS33%22%7D%2C%7B%22id%22%3A1362%2C%22value%22%3A%2212%2F03%2F2015%22%7D%2C%7B%22id%22%3A1363%2C%22value%22%3A%2212%2F31%2F2015%22%7D%5D%2C%22state%22%3A1%7D&jsessionid=AE5B03C9791D1019DCD7BBF0E34CCFEE