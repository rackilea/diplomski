public static void main(String[] args) throws IOException {
    HSLFSlideShow ppt = new HSLFSlideShow();
    HSLFSlide slide = ppt.createSlide();
    HSLFTextBox tb = slide.createTextBox();
    tb.setAnchor(new Rectangle(100, 100, 200, 200));

    HSLFTextRun titleTR = tb.appendText("Title", false);
    tb.appendText("\n", false);

    HSLFTextRun bullet1TR = tb.appendText(" bullet1", true);
    bullet1TR.getTextParagraph().setBullet(true);

    HSLFTextRun bullet2TR = tb.appendText(" bullet2", true);
    bullet2TR.getTextParagraph().setBullet(true);

    titleTR.setBold(true);

    FileOutputStream fos = new FileOutputStream("bullet.ppt");
    ppt.write(fos);
    fos.close();
    ppt.close();
}