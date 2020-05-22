controller.addSeed("https://www.google.de");

controller.startNonBlocking(() -> {
    return new MyCrawler(urlsQueue);
}, 4);

controller.addSeed("https://www.google.de/test");

controller.waitUntilFinish();