//...
private String myText = "I'm in the superclass";

private void setMyText(String myTextValue)
{
    this.myText = myTextValue;
}

public void setMyTextPublic(String myTextValue)
{
    setMyText(myTextValue);
}

public String getMyText()
{
    return myText;
}
//...