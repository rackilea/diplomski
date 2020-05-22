public void Profit(BusinessProject bp) {

    double difference = (bp.TotalRevenue - bp.TotalExpenses);

    if (difference <=1000) {

        System.out.println("Net Profit: " + (difference - (difference * 0.00175)));
    }

}