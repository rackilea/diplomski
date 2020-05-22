public String addToB(int amount){
       String msg = "";
        try{
            b.add(amount);
            msg ="successful";
        }catch(Exception ex){
            try{
                b.add(-amount);
            }catch(Exception ex2){
            }
           msg= "Amount was negative. It was inverted and then added.";
        }
 return msg;
    }