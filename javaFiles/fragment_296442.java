GroupedFeed findFeed(String locateSport){ 
    if ((!gfList.isEmpty()){
        for (int i = 0; i != gfList.size();i++){
            if (gfList.get(i).category.equalsIgnoreCase(locateSport)){
                return gfList.get(i);
            }
        }
    }
    return null;
}