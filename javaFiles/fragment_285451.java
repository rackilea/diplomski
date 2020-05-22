public static boolean sameTextureRegions(Sprite sprite1, Sprite sprite2) {
    return sprite1.getTexture().equals(sprite2.getTexture()) &&
        sprite1.getRegionX() == sprite2.getRegionX() &&
        sprite1.getRegionY() == sprite2.getRegionY() &&
        sprite1.getRegionWidth() == sprite2.getRegionWidth() &&
        sprite1.getRegionHeight() == sprite2.getRegionHeight();
}