public class Outer extends PircBot { 
private int x;
Inner n = new Inner(); //Now instantiation is outside constructor
public Outer(){
x = 5;
//no more instantiation inside constructor 
}
public class Inner extends SessionAdapter { 
...    
}
}