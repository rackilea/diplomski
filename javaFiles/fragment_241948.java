String urlPlace = "http://initial.com";

        if(args != null && args.length > 0)
        {
            urlPlace = args[0];
        }

        URI uri = new URI(urlPlace);
        String host = uri.getHost();
        int port = uri.getPort();
        if(port == -1)
        {
            port = 80;
        }