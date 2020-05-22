AvailableExpenseView btv;

        if (convertView == null) {
            // dont create your view with an item
            btv = new AvailableExpenseView(context);
        } else {
            btv = (AvailableExpenseView) convertView;
        }

        // Assign the expense wether it is a newly created view or
        // a view that is reused
        btv.setExpense(expenses.get(position));