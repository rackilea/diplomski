// Get area of the shape and print it.
try {
    double area = shape.getArea();
    System.out.println("The area is: " + area); // <-- if the previous line throws
                                                // an exception, this will not print.
}
catch(ExceptionCheck e){
    System.out.printf(e.getMessage());
}