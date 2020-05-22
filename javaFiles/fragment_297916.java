while(true) {
    theUrl = bufferedUrlReader.readLine();

    if (!theURL) { // Or "if (theURL == null)"
        break;
    }

    URL url = new URL(theUrl);
    ...