CREATE TEMP TABLE tmp_orders AS
SELECT * FROM orders;

ANALYZE tmp_orders; -- temp tables are not auto-analyzed!

ALTER TABLE tmp_orders
ADD constraint orders_pk PRIMARY KEY (order_nr, source);