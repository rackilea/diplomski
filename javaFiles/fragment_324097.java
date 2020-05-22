public class Outer extends PircBot { 
private int x;
public Outer(){
x = 5;
Inner n = new Inner(); //Instantiation inside Outer class's default constructor
}
public class Inner extends SessionAdapter { 
...    
}
}