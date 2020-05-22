elements.forEach(div -> {
        // dissect element
        String text = div.ownText();
        Elements children = div.children();

        // clear any existing inner HTML and replace it with an empty String.
        div.text("");

        // put all elements back together and wrap the div text with the span tag
        div.prepend(String.format("<span>%s</span>", text));
        children.forEach(div::appendChild);
    });

    LOG.info(jsoupDocument.toString());