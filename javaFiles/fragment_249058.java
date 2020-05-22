private static final float A4_SIZE_UNIT=2.8346457f;
    public static final int FAILURE = 2;
    public static final int BLANK = 0;
    public static final int NOTBLANK = 1;
    // value where we can consider that this is a blank image
    // can be much higher depending of the TIF source 
    // (ex. scanner or fax)
    public static final int BLANK_THRESHOLD = 1000;
    public static final int MAXIMUM_WIDTH = 500;
public static void convertTextToTif(String fileName) throws IOException {


        String filenmewithoutExtn=fileName.substring(0, fileName.lastIndexOf("."));
        BufferedReader br = null;
        String sCurrentLine;
        PdfConverter t=new PdfConverter();
        PdfConverter.PageMetaData pmdata=t.new PageMetaData();
        pmdata.setLineCount(0);
        pmdata.setyCount(820);


        PDDocument document = new PDDocument();
        PDFont font = PDType1Font.HELVETICA;

//For Each Page:
        PDRectangle a4Size=new PDRectangle(210*A4_SIZE_UNIT,297*A4_SIZE_UNIT);
        PDPage page = new PDPage(a4Size);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
       contentStream.setFont(font, 10);

        br = new BufferedReader(new FileReader(fileName));

        while ((sCurrentLine = br.readLine()) != null ) {
            System.out.println(sCurrentLine);
            sCurrentLine=removeUnicode(sCurrentLine);
            writeToPdf(sCurrentLine,contentStream,pmdata);
            if ((pmdata.getLineCount()%52)==0){
                pmdata.setLineCount(0);
                pmdata.setyCount(820);
                contentStream.close();
                document.addPage(page);

                  page = new PDPage(a4Size);
                 contentStream = new PDPageContentStream(document, page);
                 contentStream.setFont(font, 10);
                 if(pmdata.getLine()!=null){
                 writeToPdf(pmdata.getLine(),contentStream,pmdata);
                 }

            }
        }



       contentStream.close();
        document.addPage(page);

//After All Content is written:
        document.save(filenmewithoutExtn+".pdf");
        document.close();
        if (br != null)br.close();
        convertPDFtoTiff(filenmewithoutExtn+".pdf");
       File sFile = new File(filenmewithoutExtn+".pdf");
        sFile.delete();


    }

    public static PdfConverter.PageMetaData  writeToPdf(String line,PDPageContentStream contentStream,PdfConverter.PageMetaData pmdata) throws IOException{
        if( pmdata.getLineCount()!=0 && (pmdata.getLineCount()%52)==0)
        {
            pmdata.setLine(line);
            return pmdata;
        }
        if(line.length()>95){
        String pageLenghthString=line.substring(0,95);
        int lastSpaceIndex=pageLenghthString.lastIndexOf(" ");
        String lineToPrint=null;
        if(lastSpaceIndex>-1){
            lineToPrint=line.substring(0, lastSpaceIndex);
        }else{
            lineToPrint=line;
        }

        contentStream.beginText();
        contentStream.moveTextPositionByAmount(20, pmdata.getyCount());
        contentStream.drawString(lineToPrint);  
         contentStream.endText();
         pmdata.setLineCount(pmdata.getLineCount()+1);
         pmdata.setyCount(pmdata.getyCount()-15);
         if(lastSpaceIndex>-1){
         writeToPdf(line.substring(lastSpaceIndex).trim(),contentStream,pmdata);
         }else{
             writeToPdf(line.substring(95).trim(),contentStream,pmdata); 
         }

        }else{
            pmdata.setLineCount(pmdata.getLineCount()+1);
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(20, pmdata.getyCount());
            pmdata.setyCount(pmdata.getyCount()-15);
            contentStream.drawString(line); 
             contentStream.endText();

        }

        return pmdata;
    }
    public class PageMetaData{
        private Integer lineCount;
        private Integer yCount;
        private String line;
        public Integer getLineCount() {
            return lineCount;
        }
        public void setLineCount(Integer lineCount) {
            this.lineCount = lineCount;
        }
        public Integer getyCount() {
            return yCount;
        }
        public void setyCount(Integer yCount) {
            this.yCount = yCount;
        }
        public String getLine() {
            return line;
        }
        public void setLine(String line) {
            this.line = line;
        }

public static void  convertPDFtoTiff(String fileName) throws IOException{


        System.out.println("Document convertion started");
        String sourceDir = fileName; // Pdf files are read from this folder

        String filenameWithoutExtn=fileName.substring(0, fileName.lastIndexOf("."));
        String destinationDir = filenameWithoutExtn+".tif"; // converted images from pdf document are saved here
        File logFile =null;
        File destinationFile=null;
        ImageOutputStream ios=null;
        PDDocument document=null;
        ImageWriter writer=null;
        BufferedWriter fileWriter = null;
     try{
         File sourceFile =new File(sourceDir);
         logFile = new File(sourceDir.substring(0, sourceDir.lastIndexOf("\\"))+"/javalog.txt");
         fileWriter = new BufferedWriter(new FileWriter(logFile));
         destinationFile = new File(destinationDir);

            ios = ImageIO.createImageOutputStream(destinationFile);
            writer = ImageIO.getImageWritersByFormatName("tif").next();
            writer.setOutput(ios); 
            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionType("JPEG");
            param.setCompressionQuality(.5f);


             document = PDDocument.load(sourceFile);




          PDFRenderer renderer=new PDFRenderer(document);
          int totalPages=document.getNumberOfPages();
            //System.out.println("Total pages to be converted -> "+ totalPages);
            fileWriter.write("Total pages to be converted -> "+ totalPages);   
            int pageNumber = 1;

            for (int count=0;count<totalPages;count++) {

                BufferedImage image = renderer.renderImageWithDPI(count, 300);

                BufferedImage blackAndWhiteRotated=null;

                BufferedImage blackAndWhite = new BufferedImage(
                        image.getHeight(null), image.getHeight(null),
                        BufferedImage.TYPE_BYTE_GRAY);

                        Graphics2D g2 = blackAndWhite.createGraphics();
                        //g2.translate(170, 0);
                        g2.rotate(90.0 * Math.PI / 180.0,
                                blackAndWhite.getWidth()/2.0 , blackAndWhite
                                .getHeight() /2.0);


                        g2.drawImage(image, 0, 0, null);
                        //g2.r
                        //g2.rotate(45);

                        AffineTransform identity = new AffineTransform();

                        IIOImage img = new IIOImage(blackAndWhite, null, null);


                        if(pageNumber==1){
                   writer.write(null, img, param);

                   }
                   else{
                       writer.writeInsert(-1, img, param);

                   }
                   image.flush();
                   g2.dispose();     
                pageNumber++;
            }

            fileWriter.write("Document converted successfully");   
            //System.out.println("Image Created -> "+ destinationFile.getName());

            }
            catch(Exception e){

                fileWriter.write(e.toString());
                e.printStackTrace();

            }finally{
                 fileWriter.close();
                 document.close();
                  ios.flush();
                   ios.close();
                   writer.dispose();


            }

            //System.out.println("Converted Images are saved at -> "+ destinationFile.getAbsolutePath());

            System.out.println("Document converted successfully");

    }

/**
     * Creates an Image from a byte array
     * @param data  
     * @return Image
     * @throws IOException 
     * @throws Exception  
     */
    public static Image load(byte[] data) throws IOException   {
        Image image = null;
        SeekableStream stream;
        String[] names =null;
        ImageDecoder dec=null;
        RenderedImage im=null;
        try {
            //Create data stream from byte array
              stream = new ByteArraySeekableStream(data);
              names = ImageCodec.getDecoderNames(stream);
              //Create image decoder
              if(names!=null){
             dec = 
              ImageCodec.createImageDecoder(names[0], stream, null);
             im = dec.decodeAsRenderedImage();
              }else{
                  return null;
              }
        } catch (IOException e) {
            throw e;

        }


        //create image
        image = PlanarImage.wrapRenderedImage(im).getAsBufferedImage();
        // scale-down the image , maximum width : 500 px
        // to preserve memory
        Image imageScaled = 
            image.getScaledInstance(MAXIMUM_WIDTH, -1,  Image.SCALE_SMOOTH);
        return imageScaled;
      }

    /**
     * Converts an Image to a BufferedImage
     * @param im  une Image
     * @return BufferedImage  
     */
    public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage
           (im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
     }