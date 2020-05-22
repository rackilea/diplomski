public class Inner2{

private Inner1 inner1;

public Inner2(Inner1 inner1){
   this.inner1 = inner1;
}

public int getDesiredProperty(){
    return inner1.getDesiredProperty();    
}

}