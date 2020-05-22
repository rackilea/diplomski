public static void testCase() throws NullPointerException{
        try{
            System.out.println("Start");
            String out = null;
            Exception e = null;

            try
            {
                out.toString();
            }
            catch(Exception ex)
            {
                e = ex;
            }
            System.out.println("Stop");

            if(e != null)
                throw e;

        }catch(Exception e){
            System.out.println("Exception");
        }
    }