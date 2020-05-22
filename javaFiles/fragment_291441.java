MyController mc = new MyController();
mc.setInitData(myData);
FXMLLoader loader = new FXMLLoader();
loader.setController(mc);
...
loader.load();