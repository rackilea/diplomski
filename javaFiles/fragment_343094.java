EventString temp = new EventString("test");

temp.addMyEventListener(() -> {
    System.out.println("hello world detected");
});

temp.setValue("hello world");