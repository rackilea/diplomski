private static Image createSVGImage(PdfWriter pdfWriter, String imageEntry) throws BadElementException, IOException {
        Image image = null;
        final BufferedImage[] imagePointer = new BufferedImage[1];

        PdfContentByte pdfCB = new PdfContentByte(pdfWriter);   

         try {

                TranscoderInput input = new TranscoderInput(new FileInputStream(imageEntry));

                ImageTranscoder t = new ImageTranscoder() {

                    @Override
                    public BufferedImage createImage(int w, int h) {
                        return new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                    }

                    @Override
                    public void writeImage(BufferedImage img, TranscoderOutput output) throws TranscoderException {
                        // TODO Auto-generated method stub
                         imagePointer[0] = img;

                    }
                };
                t.addTranscodingHint(ImageTranscoder.KEY_FORCE_TRANSPARENT_WHITE,
                        Boolean.FALSE);
                t.addTranscodingHint(ImageTranscoder.KEY_BACKGROUND_COLOR, Color.white);
                t.transcode(input, null);
            }
            catch (TranscoderException ex) {
                // Requires Java 6
                ex.printStackTrace();
                throw new IOException("Couldn't convert ");
            }

          image = Image.getInstance(pdfCB, imagePointer[0], 1);     

        return image;
    }