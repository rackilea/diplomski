int[] ord = new int[propertyCount];
int[] frei = new int[propertyCount];
int[] margin = new int[propertyCount];

for (int j = 0; j < propertyCount; j++)
{           
    int orderNo = Integer.parseInt(table.getPropertyAsString("Order_No"));
    int freightRate = Integer.parseInt(table.getPropertyAsString("Freight_Rate"));
    int marginPercent = Integer.parseInt(table.getPropertyAsString("Margin_Percent"));

    ord[j] = orderNo;
    frei[j] = freightRate;
    margin[j] = marginPercent;

}                   

// process the arrays;