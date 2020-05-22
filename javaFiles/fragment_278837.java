Shape shape = new Circle(scan.nextDouble()); // Use variable of type shape here

..

// this code is the same for all shapes
double boundaryLength = shape.getBoundaryLength(length);
double area = shape.getArea(length);
System.out.println("Boundary Length = " + Math.round(boundaryLength));
System.out.println("Area = " + Math.round(area));