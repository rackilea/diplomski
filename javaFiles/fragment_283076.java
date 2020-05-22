try {
        URI search = new URI("http://www.lala.com/");
        new HttpGet(search);
    } catch (URISyntaxException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }