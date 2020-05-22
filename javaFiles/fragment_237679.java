regress=> \x
Expanded display is on.
regress=> SELECT 
              2012-03-12 AS unquoted,
              pg_typeof(2012-03-12) AS unquotedtype,
              '2012-03-12' AS quoted,
              pg_typeof('2012-03-12') AS quotedtype, 
              DATE '2012-03-12' AS typespecified,
              pg_typeof(DATE '2012-03-12') AS typespecifiedtype;
-[ RECORD 1 ]-----+-----------
unquoted          | 1997
unquotedtype      | integer
quoted            | 2012-03-12
quotedtype        | unknown
typespecified     | 2012-03-12
typespecifiedtype | date

(1 row)