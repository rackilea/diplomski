public String locationToString(Location l){
    String world = l.getWorld().getName(); //get the world name
    Double x = l.getX(); //get the x coordinate
    Double y = l.getY(); //get the y coordinate
    Double z = l.getZ(); //get the z coordinate

    return world + "," + x + "," + y + "," + z; //return the location, but in string form
}