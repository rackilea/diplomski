public void createQry(String s){
    String temp = s;

    if(temp.contains(")OR)")){
        temp = temp.replace(")OR)", "))");
    }
    if(s.contains(")AND)")){
        temp = temp.replace(")AND)", "))");
    }
    System.out.println(temp);        
}