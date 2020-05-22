Color color;
try {
    Field field = Class.forName("java.awt.Color").getField("yellow");
    color = (Color)field.get(null);
} catch (Exception e) {
    color = null; // Not defined
}