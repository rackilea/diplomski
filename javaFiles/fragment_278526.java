long[][] listOrders = database.getUnfinishedOrders();
final Map<Long, Set<Long>> ordersModel = buildModel(listOrders);

for (Map.Entry<Long, Set<Long>> entry : ordersModel.entrySet()) {
    TreeItem iItem = new TreeItem (tree, 0);
    iItem.setText(entry.getKey().toString()); 
    for (Long child : entry.getValue()) {
       TreeItem jItem = new TreeItem (iItem, 0);
       jItem.setText (child.toString());
    }
}