RenderedOp op = JAI.create("fileload", filename);
        // gets the number of channels (R / RGB / RGBA)
        channels =  op.getColorModel().getNumColorComponents();
        // gets the depth of each component (16 16 16)
        depth = new int[channels];
        for(int i=0; i<op.getColorModel().getNumColorComponents(); i++)
        {
            depth[i] = op.getColorModel().getComponentSize(i);
        }
        // gets the BufferedImage
        image = op.getAsBufferedImage();