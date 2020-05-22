public MyExtendedJPanel()
    {
        //I use an ArrayList because it will keep the Painters in order
        List<Painter> layerPainters = new ArrayList<Painter>();

        TilePainter tilePainter = new TilePainter(Does,This,Need,Args);
        EntityPainter entityPainter = new EntityPainter(Does,This,Need,Args);

        //Layers will be painted IN THE ORDER THEY ARE ADDED
        layerPainters.add(tilePainter);
        layerPainters.add(entityPainter);

    }