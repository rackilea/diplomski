ArrayList<Location> prev = new ArrayList<Location>();
for (Banner bannerList : bannerLists) {
    Location location = bannerList.getLocation();
    if (!prev.contains(location)) {
        location.setLocationName("1 - " + location.getLocationName());
        prev.add(location);
    }

    log.info("LOCATION " + bannerList.getId() + " : " 
                     + bannerList.getLocation().getLocationName());
}