//We create someVar on the method's scope
int someVar = 0

if(something) { //Start of if scope

    //This "if scope" is a child scope, so it inherits parent's scope
    //Can access the parent scope
    someVar = 2;

} //End of if scope

System.out.println(someVar); //Can access someVar! It wasn't defined on a child scope