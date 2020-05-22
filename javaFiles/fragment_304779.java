if (convertView == null) {
            // You create a view using the proper item
            btv = new AvailableExpenseView(context, expenses.get(position)); 
        } else {
            // You don't override the item that was previously assigned 
            // when the view was created
            btv = (AvailableExpenseView) convertView;
        }