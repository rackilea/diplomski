public Location stringToLocation(String s){
    String[] str = s.split(","); //split s by ','
    World world = Bukkit.getWorld(str[0]); //get the world
    Double x = Double.parseDouble(str[1]); //get the x coord
    Double y = Double.parseDouble(str[2]); //get the y coord
    Double z = Double.parseDouble(str[3]); //get the z coord

    return new Location(world, x, y, z); //return a location created from the String
}