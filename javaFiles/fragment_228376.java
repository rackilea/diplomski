Rectangle paintArea = new Rectangle(width, height);
      ReferencedEnvelope mapArea = map.getBounds();

      renderer = new StreamingRenderer();
      renderer.setContext(map);

      RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
      renderer.setJava2DHints(hints);

      Map rendererParams = new HashMap();
      rendererParams.put("optimizedDataLoadingEnabled",new Boolean(true) );

      renderer.setRendererHints( renderParams );

      renderer.paint(graphic, paintArea, mapArea);