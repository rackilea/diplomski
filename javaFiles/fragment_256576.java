List<ScatterMesh> scatterMeshList = new ArrayList<>();

// Collect different heights
List<Float> heights = cubes.stream()
            .map(b -> b.z)
            .distinct()
            .collect(Collectors.toList());


scatterMeshList = heights.stream()
        .map(h -> {
            List<Point3D> cubesPerH = cubes.stream()
                    .filter(p -> p.z == h)
                    .collect(Collectors.toList());
            int colorIndex = (int)cubesPerH.get(0).f;

            ScatterMesh scatterMesh = new ScatterMesh(cubesPerH, 20);
            scatterMesh.setMarker(MarkerFactory.Marker.CUBE);
            scatterMesh.setTextureModeNone(colors.get(colorIndex));
            return scatterMesh;
        })
    .collect(Collectors.toList());