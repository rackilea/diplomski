public void jump() {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= jumpForce; i++) {
                    velocity.y++;
                    System.out.println("Adding force");
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {}
                }
            }
        }).start();
    }