boolean done = false;
    while (!done) {
        htmlContents = htmlContents.substring(start);
        int startIndex = htmlContents.indexOf("<A HREF");
        if (startIndex != -1) {
            startIndex += 9;
            String currentLink = "";
            while (htmlContents.charAt(startIndex) != '"') {
                currentLink += htmlContents.charAt(startIndex);
                startIndex++;
            }
            start = startIndex;
            links.add(currentLink);
        } else {
            done = true;
        }
    }

    return links;
}