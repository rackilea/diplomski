public class ColorSerializer extends Serializer<Color> {
    @Override
    public Color read(Kryo kryo, Input input, Class<Color> clazz) {
        return new Color(input.readInt());
    }

    @Override
    public void write(Kryo kryo, Output output, Color color) {
        output.write(color.getRGB());
    }
}