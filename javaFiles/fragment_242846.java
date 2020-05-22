private OrderStatus getStatus(String shortName)
{
    switch(shortName)
    {
        case "A":
            return OrderStatus.ACTIVE;
        case "I":
            return OrderStatus.AWAITING;
        default:
            throw new RuntimeException("Cannot find order status for short name: " + shortName);
    }
}