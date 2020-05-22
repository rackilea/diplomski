static void wrapTextWithElement(TextNode textNode, String strToWrap, String wrapperHTML) {

    while (textNode.text().contains(strToWrap)) {
        // separates part before strToWrap
        // and returns node starting with text we want
        TextNode rightNodeFromSplit = textNode.splitText(textNode.text().indexOf(strToWrap));

        // if there is more text after searched string we need to
        // separate it and handle in next iteration
        if (rightNodeFromSplit.text().length() > strToWrap.length()) {
            textNode = rightNodeFromSplit.splitText(strToWrap.length());
            // after separating remining part rightNodeFromSplit holds
            // only part which we ware looking for so lets wrap it
            rightNodeFromSplit.wrap(wrapperHTML);
        } else { // here we know that node is holding only text to wrap
            rightNodeFromSplit.wrap(wrapperHTML);
            return;// since textNode didn't change but we already handled everything
        }
    }
}