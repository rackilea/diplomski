AClass ac = new AClass();
HClass hc = new HClass();
hc.setSomefield("some value goes here");

ac.getSecondIds().add(hc);

HClass hc2 = new HClass();
hc2.setSomefield("another value goes here");
ac.getThirdIds().add(hc2);

persistAClass(ac);