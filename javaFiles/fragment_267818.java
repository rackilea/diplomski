class Access{

    public static void main(String args[]){

        OtherClass other = new OtherClass();            

        //this is not valid - because accessMe is declared as private in OtherClass
        //meaning you can only use/access accessMe variable inside the scope of OtherClass
        //If you had to access this variable, you would put a getter/setter in your OtherClass implementation.
        int accessMe = other.accessMe;

        //this is valid - because there is no particular restriction on accessMe2 inside OtherClass
        int accessMe2 = other.accessMe2;

        //this is not valid since accessMe3 is declared inside the local scope (which is the contructor of OtherClass)
        //You do not have access to accessMe3 except inside the constructor
        int accessMe3 = other.accessMe3;

        //this is valid since accessMe4 is a static variable
        int accessMe4 = OtherClass.accessMe4;

    }


}