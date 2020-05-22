List<Integer> x = new ArrayList<>();
List<Double> y = new ArrayList<>();
while (rs.next()) {
    x.add(rs.getInt(1));
    y.add(rs.getDouble(2));
}
System.out.println("x: " + x + ",");
System.out.println("y: " + y + ",");