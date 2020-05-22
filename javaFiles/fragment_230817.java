//...
public void setMyTextInTheSuperClass(String myTextValue)
{
    System.out.println(getMyText());
    setMyTextPublic(myTextValue);
    System.out.println(getMyText());
}

public void setConstantValueToMyText()
{
    setMyTextInTheSuperClass("I am in the child class");
}
//...