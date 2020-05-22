try{
    UUID uuid = UUID.fromString(someUUID);
    //do something
} catch (IllegalArgumentException exception){
    //do whatever you want here if its not a uuid
}