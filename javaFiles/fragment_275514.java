try {
       Integer.parseInt(s);
       return true;
    }
    catch(NumberFormatException e){
        return false;
    }