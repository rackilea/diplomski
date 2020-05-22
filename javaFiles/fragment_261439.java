public static void main(String[] args) throws Exception {
  if (args.length > 1) {
    // grab the output image type from the first image in the sequence
    BufferedImage firstImage = ImageIO.read(new File(args[0]));

    // create a new BufferedOutputStream with the last argument
    ImageOutputStream output = 
      new FileImageOutputStream(new File(args[args.length - 1]));

    // create a gif sequence with the type of the first image, 1 second
    // between frames, which loops continuously
    GifSequenceWriter writer = 
      new GifSequenceWriter(output, firstImage.getType(), 1, false);

    // write out the first image to our sequence...
    writer.writeToSequence(firstImage);
    for(int i=1; i<args.length-1; i++) {
      BufferedImage nextImage = ImageIO.read(new File(args[i]));
      writer.writeToSequence(nextImage);
    }

    writer.close();
    output.close();
  } else {
    System.out.println(
      "Usage: java GifSequenceWriter [list of gif files] [output file]");
  }
}