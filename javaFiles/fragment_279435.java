public void HiLo(int[] numbers){

    Runnable r2 = new Runnable(){
        @Override
        public void run() {
            int high = numbers[0];
            int low = numbers[0];
            System.out.println("The highest value is: ");