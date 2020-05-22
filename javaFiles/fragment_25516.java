public double totalPaid()
{
    double total = 0.0;
    for (Ticket t:tickList)
        total+= tickList.getPrice();
    return total;
}