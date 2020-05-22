for (int i = 0; i < lines.size(); i++)
    {
        String line = lines.get(i);

        String[] values = line.split("\\s+");

        double lat = Double.parseDouble(values[0]);
        double lon = Double.parseDouble(values[1]);

        points.add(new GisPoints(lat, lon));
    }