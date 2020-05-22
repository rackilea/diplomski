public class MyClass{
//The necessary stuff
private Integer valueFromDB; //0, 1, 2...
private Map<Integer, String> itemStatusListReversedString; //The map you configured in the faces-config.xml

//More stuff

public String getStringValue(){
 return itemStatusListReversedString.get(this.valueFromDB);
}

}