ImageIO.scanForPlugins();
ByteArrayOutputStream output_stream=new ByteArrayOutputStream();            
try 
{
    ImageOutputStream output = ImageIO.createImageOutputStream(output_stream);
    ImageWriter writer = new TIFFImageWriterSpi().createWriterInstance();
    writer.setOutput(output);
    writer.prepareWriteSequence(null);
    writeToSequence(new IIOImage(ImageIO.read(new ByteArrayInputStream(bytes)),null,null),null);
    writer.endWriteSequence();
    writer.dispose();           
    output.flush();
    output.close();