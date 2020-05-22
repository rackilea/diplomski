class myObject1 {
    public String myName = "";
    // constructor - no return value
    public myObject1 (String aName) {
        this.myName = aName;
    }

    public void printMyName() {
        System.out.println("Object 1: My Name is: " + this.myName);
    }
}

class myObject2 {
    public String myName = "";
    // constructor - no return value
    public myObject2 (String aName) {
        this.myName = aName;
    }

    public void printMyName() {
        System.out.println("Object 2: My Name is: " + this.myName);
    }
}


class runClass {
    public static void main(String[] args) {

        Object [] elements = new Object[2];
        elements[0] = new myObject1("Jon Doe");
        elements[1] = new myObject2("Mr. Smith");

        for (int i = 0; i < elements.length; i++) {
            runClass.workOnElement(elements[i]);
        }
    }

    public static void workOnElement (Object theElem) {
      if (theElem instanceof myObject1) {
        myObject1 elem = (myObject1) theElem;
        elem.printMyName();
      } else if (theElem instanceof myObject2) {
        myObject2 elem = (myObject2) theElem;
        elem.printMyName();
      }
    }
}