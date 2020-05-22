URL imgURL = getClass().getClassLoader().getResource(url);
    if (imgURL != null) {
       return imgURL;
    } else {
       return null;
    }