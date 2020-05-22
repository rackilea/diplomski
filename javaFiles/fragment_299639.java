new Thread(
        new Runnable() {
            public void run() {
                try {
                   runLocales(langLocale);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(
                    "child thread  " + new Date(System.currentTimeMillis()));
            }
        }).start();