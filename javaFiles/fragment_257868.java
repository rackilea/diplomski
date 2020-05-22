for (int i = 0; i < 10; i++) {
    outputStream.write(123);
    outputStream.flush();
    System.out.println("flush...");
    Thread.sleep(10_000);
}