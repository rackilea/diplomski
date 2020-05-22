for (int i = 0; i < TIMES_TO_CALL_PING; i++) {
    new OVThread(index, new Runnable() {

            @Override
            public void run() {
                try {
                    ...
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    ...
}