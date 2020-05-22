CREATE TABLE t (
    id SERIAL PRIMARY KEY,
    c1 text,
    c2 text,
    c3 text
) ;

CREATE EXTENSION file_fdw;
CREATE SERVER my_csv_server FOREIGN DATA WRAPPER file_fdw;

CREATE TABLE csv (
    id integer,
    c1 text,
    c2 text,
    c3 text
) 
SERVER my_csv_server 
OPTIONS ( filename '/home/me/data.csv', format 'csv' );

SELECT
     id,
     CASE 
         WHEN t.c1 = csv.c1 AND t.c2 = csv.c2 AND t.c3 = csv.c3 THEN
             'Max'
         WHEN t.c1 = csv.c1 AND t.c2 = csv.c2 THEN
             'High'
         WHEN t.c1 = csv.c1 THEN
             'Mid'
         ELSE
             'Low' -- only id match
    END as report
FROM 
    t JOIN csv USING (id)