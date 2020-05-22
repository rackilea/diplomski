public void methodA(){
    print("entering method A..");   //(1)methodA invoked..
    methodB();                      //(2)call methodB
    print("exiting method A");      //(8)exit from methodB, continue from here
}

public void methodB(){               
    print("entering method B..");   //(3)mthodB invoked..
    methodC();                      //(4)call methodC
    print("exiting method B");      //(7)exit from methodC, continue from here. exit methodB
}

public void methodC(){
    print("entering method C..");   //(5)methodC invoked..
    print("exiting method C");      //(6)exit methodC, continue from whoever called methodC
}