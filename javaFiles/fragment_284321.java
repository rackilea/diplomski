public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            // ... create GUI ... create Threads ...

            new Thread(new Runnable() {
                @Override
                public void run() {
                    // ... start Threads ... join Threads ...
                }
            }).start();
        }
    }
}