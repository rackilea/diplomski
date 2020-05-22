public static void main(String[] args) {
    new Thread(){
        @Override
        public void run() {
            System.out.println("##");
        }
    }.start();


    // how can you declare a variable of the above type *with* its behavior?
}