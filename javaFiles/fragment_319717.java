new Thread(() -> {
    for (;;) {
        synchronized (board) {
            System.out.println(board.getFirstName() + ' ' + board.getLastName());
        }
    }
}).start();