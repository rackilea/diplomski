String[] imageNames = { "background", "character", "Bob" };
Map<String, Image> map = new HashMap<String, Image>();

for (String imageName: imageNames) {
    Image backGroundImage = 
            ImageIO.read(getClass().getResource("/data/" + imageName + ".png"));
    map.put(imageName, backGroundImage);
}