Map<Shape, Object> map = new HashMap<>();
java.awt.geom.Rectangle2D.Double shape = new java.awt.geom.Rectangle2D.Double(1, 1, 1, 1);
map.put(shape, null);
System.out.println(map.size()); //1
shape.setRect(2, 2, 2, 2); //mutate
System.out.println(map.size()); //still 1
map.keySet().remove(shape);
System.out.println(map.size()); //still 1