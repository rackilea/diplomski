double sideA = myTri.getSideA();
    double sideB = myTri.getSideB();
    double sideC = myTri.getSideC();
    double angleA = myTri.getAngleA();
    double angleB = myTri.getAngleB();
    double angleC = myTri.getAngleC();
    double perim = myTri.getPerimeter();
    double area = myTri.getArea();

    String[] columnName = {"SIDES", "ANGLES", "PERIMETER", "AREA"};
    Object[][] data = {
            {"Side A = " + df.format(sideA),
             "Angle A = " + df.format(angleA) + "\u00b0",
             "Perimeter = " + df.format(perim),
             "Area = " + df.format(area)},
            {"Side B = " + df.format(sideB),
             "Angle B = " + df.format(angleB) + "\u00b0",
             " ", " "},
            {"Side C = " + df.format(sideC),
             "Angle C = " + df.format(angleC) + "\u00b0",
             " ", " "}
        };