public void onBindViewHolder(TableViewHolder tableViewHolder, int i) {
    final TimeTable ci = tableList.get(i);

    //...

    tableViewHolder.setOnSomethingListener() {
    // You can use the ci reference here because you declared it as final
    // When this view is reused and references another position, the listener will be updated on the onBindViewHolder, to reference the new position that it will be being associated with
    }

}