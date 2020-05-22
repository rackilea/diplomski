for (int i = 0; i < 5; i++) {
    TreeColumn column = new TreeColumn(tree, SWT.CENTER);
    column.setText("Col " + i);
    column.setWidth(60);
    if (i > 0) column.setMoveable(true);

    // NEW CODE HERE
    if (i == 0) {

        column.addControlListener(new ControlAdapter() {

            public void controlMoved(ControlEvent e) {

                List<Integer> newOrder = new ArrayList<Integer>();

                // add the first
                newOrder.add(0);

                // loop around all columns
                for (int col : tree.getColumnOrder()) {

                    // if not the first that was added, add to list
                    if (col != 0) {
                        newOrder.add(col);
                    }
                }

                // convert list to array
                int[] newOrderArray = new int[newOrder.size()];
                for (int j = 0; j < newOrder.size(); j++) {
                    newOrderArray[j] = newOrder.get(j);
                }

                // update tree order
                tree.setColumnOrder(newOrderArray);
            }
        });
    }
}