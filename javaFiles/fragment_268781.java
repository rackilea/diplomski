try {
        for (i = 0; i < 1000; i++) {
            if (i % 60 == 0)
                System.out.println();
            System.out.print(“.X”.charAt(s.dif()));
            sleep(20);
        }
        System.out.println();
        done = true;
    } catch (InterruptedException e) {
        return;
    }