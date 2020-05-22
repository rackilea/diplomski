//static class to store variables
  Class StaticVariables{
  static int location=100;
 }



class ParentClass{

    //..Codes Codes..

    b1.addActionListener(new ActionListener() {
    //Calling Static class varible
    int localLocationVariable=StaticVariables.location;
    b1.setLocation(localLocationVariable,100);
    localLocationVariable+= 10;
    StaticVariables.location=localLocationVariable;
    }