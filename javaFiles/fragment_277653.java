private static String method(String str) throws Exception{
        try{
            if(str.equals("1")) return null;
            else if(str.equals("2")) throw new Exception("My Exception");
            else return str;
        }catch(Exception e){
            return null;
        }

    }