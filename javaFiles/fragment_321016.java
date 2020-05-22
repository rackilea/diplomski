Toolkit.getDefaultToolkit().createImage(
  new FilteredImageSource(
    iconToImage(icon).getSource(), 
    new CropImageFilter(leftX, topY, width, height)
  )
);