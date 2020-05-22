public String getExits (){
       List<String> exits = new ArrayList<>();
        if (north != null) exits.add("North: " + north.name);
        if (south != null) exits.add("South: " + south.name);
        if (east != null) exits.add("East: " + east.name);
        if (west != null) exits.add("West: " + west.name);
        return String.join("\n", exits);
    }