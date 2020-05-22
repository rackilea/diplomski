class TestedClass{
private final Helper helper;
public TestedClass(Helper helper){
      this.helper = helper;
}

public aMethodUsesHelper(){
    //hello is weird name for method that returns int but it is link to your code
    int aVar =this.helper.hello();
    // ...
}
// ...