CREATE OR REPLACE FUNCTION public.fx()
RETURNS foo LANGUAGE plpgsql
AS $function$
BEGIN
  RETURN (SELECT ROW(a,b) FROM foo LIMIT 1);
END;
$function$

postgres=# SELECT * FROM foo;
 a  | b  
----+----
 10 | 20
(1 row)

postgres=# SELECT fx(); -- packed composite
   fx    
---------
(10,20)
(1 row)

postgres=# SELECT * FROM fx(); -- unpacked composite
 a  | b  
----+----
 10 | 20
(1 row)