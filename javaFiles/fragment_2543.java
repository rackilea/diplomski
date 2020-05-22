// class t {   // Remove it

        public static void main(String args[]) {

            mythread m1 = new mythread("Child Thread 1");
            mythread m2 = new mythread("Child Thread 2");

            try {

            for(int i = 5 ; i > 0 ;i--) {
                System.out.println("Main Thread" + i);
                Thread.sleep(2000);
            }

        }
        catch(InterruptedException e){

            System.out.println("Main Thread Interrupted");
        }


    // }