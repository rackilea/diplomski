public int method (int a, String b) throws NullPointerException{
        try {
            System.out.println(a+"  "+b.length());
        }
        catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("catch from the method");
            throw e;
        }
        finally {
            System.out.println("finally from the method");
        }   
        return 0;
        }