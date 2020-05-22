public static void main(String[] args) {
     /* Moved Outside */
     int o[] = new int[4];

        try{
            o[3] = 23;
            o[1] = 33;
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        /* o will be visible now */
        System.out.println(o[1]);
    }