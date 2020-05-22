Color[] allAnchorColors = {
    new Color(255, 200, 63),
    new Color(255, 8, 12),
    new Color(0, 255, 148),
    new Color(223, 214, 255),
    new Color(255, 19, 19),
    new Color(0, 76, 255),
};
System.out.println("anchors.length = " + allAnchorColors.length);
System.out.println("anchors unsorted: " + Arrays.toString(allAnchorColors));
Arrays.sort(allAnchorColors, new Comparator<Color>() {
    @Override
    public int compare(Color o1, Color o2) {
        return o1.getRGB() - o2.getRGB();
    }
});
System.out.println("anchors.length = " + allAnchorColors.length);
System.out.print("anchors sorted: " + Arrays.toString(allAnchorColors));