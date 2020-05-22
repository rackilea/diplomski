In Setup:
if(dbGetConnected()) {
....
} else {
  dbisntconnected = true;
}

In tearDown:
if(!dbisntconnected) {
    dbClose();
}