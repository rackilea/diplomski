public class Person {
int number;
int age;
String name;
String code;
public Person(int number, int age, String name, String code){
    this.number = number;
    this.age = age;
    this.name = name;
    this.code = code;
}
public String toString(){
  return number+" "+age+ " "+name+" "+ code;
  /*This will output [2 20 Jake JE, 5 34 Kate KI, 3 26 Joe JL].
  return "["+number+" "+age+ " "+name+" "+ code+"]";
  This will output [[2 20 Jake JE], [5 34 Kate KI], [3 26 Joe JL]].*/

}