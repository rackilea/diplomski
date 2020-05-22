if(map1.size == map2.size && map1.equals(map2))
    //in here means the keys are the same
    allkeys = map1's keys
    for (string key : allKeys)
        //now we need to loop through the arraylists
        map1Arraylist = map1.get(key)
        map2Arraylist = map2.get(key)
        //check the sizes are the same if not return false right away
        if(map1Arraylist.size != map2Arraylist.size) return false;
        //if we got to here we now must check each index is the same
        for(index = 0; index < map1Arraylist.size; index++)
            //if a single index of the arraylists don't match up we return false
            if(map1Arraylist.get(index) != map2Arraylist.get(index))
                return false;

    //if we get out of all the above logic then we have the same maps
    return true;
else return false;