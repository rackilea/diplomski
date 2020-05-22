public static void main(String []args){
        try{
            System.out.println("try1");
            throw  new Exception("Exception1");
        }catch(Exception e){
            System.out.println("catch1");
            try{
                System.out.println("try2");
                throw  new Exception("Exception2");
            }catch(Exception e1){
                System.out.println("catch2");
            }
        }
    }