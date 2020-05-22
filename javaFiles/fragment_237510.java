public static void testCase() throws NullPointerException{
        try{
            System.out.println("Start");
            String out = null;
            out.toString();
            System.out.println("Stop");

        }catch(NullPointerException e){
            System.out.println("Stop");
            System.out.println("Exception");
        }
    }