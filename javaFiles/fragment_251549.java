geometries.stream()
            .filter(geometry -> mesh.getGeometry().equals(geometry))
            .findAny()
            .orElseGet(() -> {
                geometries.add(mesh.getGeometry());
                return mesh.getGeometry();
            });