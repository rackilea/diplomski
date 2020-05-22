class group {
    String fname,lname;

     group(String fname ){
    this.fname=fname;
    }
    group(String fname,String lname){
    this.fname=fname;
    this.lname=lname;

    }
    group(String fname,String lname,int age){
    this.fname=fname;
    this.lname=lname;
    this.age=age;
    }

  public  String getName(){

return fname+lname+age;    
}
    }