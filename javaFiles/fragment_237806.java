Sort sort = Sort.by(Sort.Direction.ASC, "abc");

for (Sort.Order order : sort)
{
    System.out.println("Property: " + order.getProperty());
    System.out.println("Direction: " + order.getDirection());
}