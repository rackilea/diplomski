if ((calculateCS == 'C') || (calculateCS == 'c'))
    {
        double radiusCircle = 0;

        System.out.print("Thank you.  What is the radius of the circle (in inches): ");
            radiusC = getRadius();  
            areaCircle = printCircleArea(radiusC);
                    System.out.printf("The area of a circle with a radius of " + radiusC + "inches is %.3f inches. \n", areaCircle );
    return true;
    }