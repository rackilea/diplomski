List<Double> coordinates = Arrays.asList(x0,y0,z0,...); // n points
List<Color> colors = Arrays.asList(new Color(),...); // n colors

// create org.fxyz3d.geometry.Point3D for each cube with x,y,z,f (index of color)
List<Point3D> cubes = new ArrayList<>();

AtomicInteger i = new AtomicInteger();
colors.stream()
      .forEach(c -> cubes.add(new Point3D(coordinates.get(i.getAndIncrement()), 
                coordinates.get(i.getAndIncrement()), 
                coordinates.get(i.getAndIncrement()),
                colors.indexOf(c))));

// create scatterMesh from cubes, each cube with a size of 20 pixels
ScatterMesh scatterMesh = new ScatterMesh(cubes, 20);

// apply `CUBE` marker
scatterMesh.setMarker(MarkerFactory.Marker.CUBE);

// apply same `f` value to all 8 vertices of each cube
scatterMesh.setFunctionData(cubes.stream()
            .flatMap(p -> Collections.nCopies(8, p.f).stream()).collect(Collectors.toList()));

// Apply texture based on the list of colors 
scatter.setTextureModeVertices3D(new Palette.ListColorPalette(colors), p -> p.f);