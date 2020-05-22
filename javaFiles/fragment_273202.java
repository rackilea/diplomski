@Override
public double getArea() throws ExceptionCheck {
    try {
        return getHeight() * getWidth();
    }
    catch(ExceptionCheck e){
        System.out.printf("The area cannot be calculated, the end point is missing!\n\n");
        throw e; // <-- add this.
    }
}