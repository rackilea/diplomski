class OrderDocument implements Comparable<ModelTask> {
    int order_id;  // The document ID
    Integer route_load_id;  // The route this order is assigned to be loaded
    Integer route_unload_id;  // The route this order is assigned to be loaded, may be same as route_load_id and viceversa
    Integer route_load_index;  // The index order in load route
    Integer route_unload_index;  // The index order in unload route
}

class OrdersComparable implements Comparator<OrderDocument> {
@Override
public int compare(OrderDocument x, OrderDocument y) {
    if (x.route_load_id == y.route_load_id && x.route_load_id != null)
        return Integer.compare(x.route_load_index, y.route_load_index);

    if (x.route_load_id == y.route_unload_id && x.route_load_id != null)
        return Integer.compare(x.route_load_index, y.route_unload_index);

    if (x.route_unload_id == y.route_load_id && x.route_unload_id != null)
        return Integer.compare(x.route_unload_index, y.route_load_index);

    if (x.route_unload_id == y.route_unload_id && x.route_unload_id != null)
        return Integer.compare(x.route_unload_index, y.route_unload_index);

    return 0;
}
}