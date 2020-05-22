boolean end = false;

new Thread(() -> {
    while (!end) {
        //...
    }
}).start();