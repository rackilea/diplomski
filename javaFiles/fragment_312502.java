private class DateTimeDeserializer implements JsonDeserializer<Point> {
    public Point deserialize(JsonElement json, Type typeOfT, 
            JsonDeserializationContext context) throws JsonParseException {
        List<PointPart> parts = Lists.newArrayList();

        for(Map.Entry<String,JsonElement> entry : 
                json.getAsJsonObject().entrySet()) {
            char type = ;
            int index = Integer.parseInt(entry.getKey().substring(1)) - 1;

            while(parts.size() <= index) {
                parts.add(new PointPart());
            }

            PointPart part = parts.get(index);
            switch(entry.getKey().charAt(0)) {
            case 'c':
                part.c = entry.getValue().getAsBoolean();
                break;
            case 'k':
                part.k = entry.getValue().getAsInt();
                break;
            }
        }

        return new Point(parts);
    }
}

class Point {
    List<PointPart> parts;

    Point(List<PointPart> parts) {
        this.parts = parts;
    }
}

class PointPart {
    boolean c;
    int k;
}