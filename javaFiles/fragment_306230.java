Link1 start = new Link1();
Link2 link2 = new Link2();
start.setNextHandler(link2);
Link3 link3 = new Link3();
link2.setNextHandler(link3);
...