public static void main(String args[]){
        final ActionListener listener = e -> {
            for(int i = 0; i <= 1000; i++)
                System.out.printf("%d\n", i);
        };
        final Timer timer = new Timer(1000, listener);
        timer.start();
    }