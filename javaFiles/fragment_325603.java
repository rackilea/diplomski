try {
        while (true) {
            System.out.println(new Date());
            Thread.sleep(5 * 1000);
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }