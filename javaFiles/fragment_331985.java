Color color;
try {
    Field field = Color.class.getField("yellow");
    color = (Color)field.get(null);
} catch (Exception e) {
    color = null; // Not defined
}