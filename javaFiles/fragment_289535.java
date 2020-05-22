int[] dstImage = new int[srcImage.width() * srcImage.height()];

srcImage.forEachElement((image, imageCol, imageRow) -> {
  Pixel pixel = new Pixel();
  forEachElement((filter, col, row) -> {
    int neighbourCol = imageCol + col - (size / 2);
    int neighbourRow = imageRow + row - (size / 2);
    if (srcImage.hasElementAt(neighbourCol, neighbourRow)) {
      int color = srcImage.at(neighbourCol, neighbourRow);
      int weight = filter.at(col, row);
      pixel.addWeightedColor(color, weight);
    }
  });

  dstImage[(imageRow * srcImage.width() + imageCol)] = pixel.rgb();
});