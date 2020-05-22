File myFile = (File) AccessController.doPrivileged(new PrivilegedAction() {
public Object run() 
{
    return new File("C:\\MyFolder\\MyFile");
}

});