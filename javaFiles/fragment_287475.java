import jankovicsandras.imagetracer.ImageTracer;
...
HashMap<String,Float> options = new HashMap<String,Float>();

options.put( "ltres", 2f ); // Linear error treshold
options.put( "qtres", 2f ); // Quadratic spline error treshold

IndexedImage myimage = ImageTracer.imageToTracedata( "input.jpg", options, null );

ArrayList<ArrayList<ArrayList<Double[]>>> mylayers = myimage.layers;
... process coordinates in mylayers