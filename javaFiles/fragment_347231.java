public void run() {
    Runnable r = new Runnable() {
        public void run() {
            count++;
            int a = count; // to see which job is started and ended.
            System.out.println(this.now("HH:mm:ssSSS")+"- start "+count);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
            System.out.println(this.now("HH:mm:ssSSS")+"- end "+a);
        }
    };

    Thread t = new Thread(r);
    t.start();
}