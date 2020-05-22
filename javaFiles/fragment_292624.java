public enum Color{
    Green, Red, Yellow;
    public static Color fromString(String stringName) {
        for(Color col : Color.values()) {
            if(col.name().equalsIgnoreCase(stringName)) {
                return col;
            }
        }

        return null;
    }
}