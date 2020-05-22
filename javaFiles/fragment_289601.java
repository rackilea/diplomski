public void run() {
    for (int i = 1; i <= 5; i++) {
        synchronized (count) {
            String name = Thread.currentThread().getName();

            if (name.equals("T1")) {
                while (count.count % 2 == 0) {
                    try {
                        count.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + " :: " + count.count);
                count.count++;
                count.notify();
            } else if (name.equals("T2")) {
                while (count.count % 2 != 0) {
                    try {
                        count.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } 
                System.out.println(name + " :: " + count.count);
                count.count++;
                count.notify();
            }
        }
    }
}