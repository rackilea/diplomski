CREATE OR REPLACE FUNCTION insert_orderhead(
    p_order_id integer, 
    p_order_dt text, 
    p_customer_id integer, 
    p_route_id integer, 
    p_routenum integer, 
    p_ordertype text, 
    p_create_station_id integer, 
    p_create_stationtype text, 
    p_create_time text, 
    p_create_user_id integer, 
    p_tran_time text, 
    p_tran_user_id integer)
  RETURNS integer AS
$BODY$
   INSERT INTO ordermaster 
     (order_dt, customer_id, route_id, routenum, ordertype, create_station_id, create_stationtype, create_time,create_user_id,tran_time, tran_user_id)
   values 
     (p_order_dt, p_customer_id, p_route_id, p_routenum, p_ordertype, p_create_station_id, p_create_stationtype, p_create_time, p_create_user_id, p_tran_time, p_tran_user_id) 
   returning  orderline_id;
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;