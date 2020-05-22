final Random mRandom = new Random(System.currentTimeMillis());

public int generateRandomColor() {
    // This is the base color which will be mixed with the generated one
    final int baseColor = Color.WHITE;

    final int baseRed = Color.red(baseColor);
    final int baseGreen = Color.green(baseColor);
    final int baseBlue = Color.blue(baseColor);

    final int red = (baseRed + mRandom.nextInt(256)) / 2;
    final int green = (baseGreen + mRandom.nextInt(256)) / 2;
    final int blue = (baseBlue + mRandom.nextInt(256)) / 2;

    return Color.rgb(red, green, blue);
}