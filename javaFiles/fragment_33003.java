// now resize the image
    ParameterBlock pb = new ParameterBlock();
    pb.addSource(image); // The source image
    pb.add(wScale); // The xScale
    pb.add(hScale); // The yScale
    pb.add(0.0F); // The x translation
    pb.add(0.0F); // The y translation

    RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);           
    RenderedOp resizedImage = JAI.create("SubsampleAverage", pb, hints);

    // lastly, write the newly-resized image to an
    // output stream, in a specific encoding
    try
    {
            FileOutputStream fos = new FileOutputStream(new File(filename));
            JAI.create("encode", resizedImage, fos, getImageType(filename), null);
            ParameterBlock ParameterBlock pb = new ParameterBlock(); 
            ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.TYPE_YCbCr), new int[] {8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
            pb.add(cm); 
            RenderedOp imgycc = JAI.create("ColorConvert", pb);
    }
    catch (FileNotFoundException e)
    {
    }