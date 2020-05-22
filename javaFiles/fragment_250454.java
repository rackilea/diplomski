try {
        java.net.URI theURI = java.net.URI.create(uri);
        // System.out.println(theURI.getScheme()); => myDocs
        String uriBrowsablePart = theURI.getRawSchemeSpecificPart();
        // System.out.println(uriBrowsablePart); => http://google.com
        Desktop.getDesktop().browse(java.net.URI.create(uriBrowsablePart));
        // the above statement will open default browser on http://google.com
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }