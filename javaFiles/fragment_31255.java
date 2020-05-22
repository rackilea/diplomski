ArrayList<OrderModel> list = new ArrayList<OrderModel>();

for (int l = 0; l < numRow; l++) {

            int orderid = Integer.parseInt(tblOrder.getValueAt(l, 0).toString());
            String customername = tblOrder.getValueAt(l, 1).toString();
            String item = tblOrder.getValueAt(l, 2).toString();
            double qty = Double.parseDouble(tblOrder.getValueAt(l, 3).toString());
            double amount = Double.parseDouble(tblOrder.getValueAt(l, 4).toString());
            double total = Double.parseDouble(tblOrder.getValueAt(l, 5).toString());
            // OrderModel object
            OrderModel ormod1 = new (orderid, customername, item, bla..bla..);
            //then add OrderModel to the list
            list.add(ormod1);

}