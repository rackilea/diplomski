public static void main(String[] args) {
        List<Location> locations = new ArrayList<Location>();

        for(int i=0; i < jLocation.length(); i++){
            String name = jLocation.getJSONObject(i).getString("name");
            String location = jLocation.getJSONObject(i).getString("location");

            locations.add(new Location(name, location));
        } 
    }