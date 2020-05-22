List<JSONObject> coordinates = (List<JSONObject>)new JSONParser().parse(objects);
List<Coordinate> sortedCoordinates = coordinates
                .stream()
                .map(raw -> convert(raw))
                .sorted(Comparator.comparing(Coordinate::getDistance))
                .collect(Collectors.toList());