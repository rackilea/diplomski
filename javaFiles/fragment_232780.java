try {
    myCode.call();
catch (Exception e) {
    System.out.println("An exception was caught at the top level:" + e);
    System.exit(-1);
}