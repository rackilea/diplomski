Datastore ds = ...;

//get/change/save
Settings s = ds.find(Settings.class).get(); //like findOne in the shell/driver
s.showFriendsList = true;
ds.save(s); 

//or update
ds.updateFirst(ds.find(Settings.class), ds.creatUpdateOperations(Settings.class).set("showFiendsList", true));