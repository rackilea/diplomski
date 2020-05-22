if (respCode >= 400) {
        if (respCode == 404 || respCode == 410) {
            throw new FileNotFoundException(url.toString());
        } else {
            throw new java.io.IOException("Server returned HTTP" +
              " response code: " + respCode + " for URL: " +
              url.toString());
        }
    }