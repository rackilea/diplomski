try {
    System.out.println("echo: " + in.readLine());
} catch (SocketTimeoutException ste) {
    // Do something
    System.out.println("nothing received");
}