public class NewClass {
String animal;
String building;
public static NewClass class1 = new NewClass("cat", "house");
public static NewClass class2 = new NewClass("dog", "shed");

public NewClass(String A, String B){
animal=A;
building=B;}


@Override
public String toString(){
    return animal+building;
}}