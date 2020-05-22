// in the method in the Plane class
Class<? extends Side> clazz = side.getClass();
Field aField = clazz.getField("a");
Field bField = clazz.getField("b");
Field cField = clazz.getField("c");

// getting the values of the fields
Point aPoint = (Point)aField.get(side);
Point bPoint = (Point)bField.get(side);
Point cPoint = (Point)cField.get(side);