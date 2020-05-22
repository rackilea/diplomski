public int setupSystem() {
    doA();

    try { doB(); }
    catch (MyException e)
    { return ERROR; } 

    doC();
    return SUCCESS;
}