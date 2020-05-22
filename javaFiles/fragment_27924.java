public int pingWorkstation() {
    doA();

    try { doB(); }
    catch (MyException e)
    { return ERROR; } 

    doC();
    return SUCCESS;
}