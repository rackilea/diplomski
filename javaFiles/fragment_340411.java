public void compare(){        
    String inputString="(123)848-3452";
    if(inputString.matches("^\\([0-9]{3}\\)[0-9]{3}-[0-9]{4}")){
        System.out.println("valid");
    }else{
        System.out.println("invalid");
    }
}