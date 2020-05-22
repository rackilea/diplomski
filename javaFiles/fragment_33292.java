for(int i=profiles.size()-1; i>=0; i--) {
    Profile p = profiles.get(i);
    profileData = new JsonObject(); // <- create a new object in each iteration
    profileData.put("name", p.name);
    profileData.put("mods", p.mods.toString());
    System.out.println(p.name + "..." + p.mods.toString());
    profileDataList.add(profileData);
    System.out.println("list.." + profileDataList.toString());
    profileListObj.put("profile"+i, profileDataList); // Is this really needed?   
}
//profileList.add(profileListObj);
obj.put("profiles", profileDataList);