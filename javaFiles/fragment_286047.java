while (true) {
    try {
        doWork("www.sears.com");
        break;
    } catch (UnknownHostException e) {
        logger.log(e.getMessage());
        Thread.sleep(10000);
    }
}