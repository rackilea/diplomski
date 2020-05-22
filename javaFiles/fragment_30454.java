public static Location getRandomLocation(int min, int max, World world) {
    int x = CommonUtils.randomInt(-max, max);//Random x coord
    int z;
    if (Math.abs(x) < min) {
        z = CommonUtils.randomInt(min, max);//If x coord is less than the minimum choose a z coord that is within range
        if (new Random().nextBoolean()) {//Top or bottom of range
            z = -z;
        }
    } else {
        z = CommonUtils.randomInt(-max, max);//Else choose any z coord
    }
    int y = 255;
    while (world.getBlockAt(x, y, z).getType() == Material.AIR) {
        y--;
    }
    return world.getBlockAt(x, y + 1, z).getLocation();
}