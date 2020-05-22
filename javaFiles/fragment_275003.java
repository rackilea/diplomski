CREATE VIEW orders AS
SELECT '1'::int            AS source -- or any other tag to identify source
      ,"OrderNumber"::text AS order_nr
      ,"InvoiceNumber"     AS tansaction_id -- no cast .. is int already
      ,"OrderDate" AT TIME ZONE 'UTC' AS purchase_date -- !! see explanation
FROM   tbl_newegg

UNION  ALL  -- not UNION!
SELECT 2
       "amazonOrderId"
      ,"merchant-order-id"
      ,"purchase-date"
FROM   tbl_amazon;