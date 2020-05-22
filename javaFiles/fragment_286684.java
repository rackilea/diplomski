public void annotateImage()
{
    IMOperation op = new IMOperation(); //imagemagick operator for command line tools

    //draw method
    op.addImage(); //input image
    op.resize(957, 626); //resizing image
    op.pointsize(20); //size of text
    op.font("Times-New-Roman"); // font
    op.fill("Black"); //font color
    op.draw("text 500,300 'works like magic!'"); // location of text, actual text 
    op.addImage();// output image

    ConvertCmd cmd = new ConvertCmd(); //using the convert command from imagemagick
    cmd.setSearchPath("C:\\Program Files (x86)\\ImageMagick-6.8.9-0"); //commands location
    FilenamePatternResolver resolver = new FilenamePatternResolver("%P/%f.jpg");

    try {
        cmd.run(op, "dest\\input.jpg", resolver.createName("dest\\output.jpg"));    
    } catch (Exception e)
    {
        e.printStackTrace();
    }
}