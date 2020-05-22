add_action( 'init', 'check_orders_update_status' );
function check_orders_update_status(){
    global $wpdb;

    $meta_key = '_need_status_update';

    // SQL query Get orders Ids that have a meta key like '_need_status_update'
    $orders_ids = $wpdb->get_col( "
        SELECT pm.post_id
        FROM {$wpdb->prefix}postmeta as pm
        WHERE pm.meta_key LIKE '$meta_key'
    " );

    if( count($orders_ids) > 0 ){
        foreach( $orders_ids as $order_id) {
            // Get an instance of the WC_Order object
            $order = wc_get_order($order_id);

            // Delete the meta data '_need_status_update'
            delete_post_meta( $order_id, $meta_key );

            // Updating Order status (will send "Customer order completed" email notification
            $order->update_status('completed');
        }
    }
}