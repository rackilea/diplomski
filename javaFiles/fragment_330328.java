float x = 50;
float y = 650;

for (Folder currFol : root.getFolders()) {
    for (Document currDoc : currFol.getDocuments()) {
        String text = currFol.getName() + "/" + currDoc.getName();
        float textWidth = font.getStringWidth(text) / 1000.0 * 12;

        PDAnnotationLink link = new PDAnnotationLink();
        PDGamma colourBlue = new PDGamma();
        colourBlue.setB(1);
        link.setColour(colourBlue);

        // add an action
        PDActionURI action = new PDActionURI();
        action.setURI(currFol.getName() + "/" + currDoc.getName());

        link.setAction(action);

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.moveTextPositionByAmount(x, y);
        contentStream.drawString(text);
        contentStream.endText();

        PDRectangle position = new PDRectangle();
        position.setLowerLeftX(x);
        position.setLowerLeftY(y - 3);
        position.setUpperRightX(x + textWidth);
        position.setUpperRightY(y + 12);
        link.setRectangle(position);

        page.getAnnotations().add(link);

        y -= 15;
    }
}