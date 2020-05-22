Image image = Image.getInstance(IMG);
image.setScaleToFitHeight(false);
PdfPTable table = new PdfPTable(1);
table.setTotalWidth(new float[]{120});
table.setLockedWidth(true);
Phrase listOfDots = new Phrase();
for (int i = 0; i < 40; i++) {
    listOfDots.add(new Chunk(image, 0, 0));
    listOfDots.add(new Chunk(" "));
}
table.addCell(listOfDots);