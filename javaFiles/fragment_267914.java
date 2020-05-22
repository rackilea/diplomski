Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.WHITE};
for (Color color: colors) {
    System.out.println(color.getRGB() + "; " + color);
}

Arrays.sort(colors, new Comparator<Color>() {
    @Override
    public int compare(Color o1, Color o2) {
        return o1.getRGB() - o2.getRGB();
    }
});
System.out.println("After");
for (Color color: colors) {
    System.out.println(color.getRGB() + "; " + color);
}