CREATE TYPE person AS ( name text, surname text, miasto text );

CREATE TABLE some_table (id integer primary key, blah text, this_person person);

INSERT INTO some_table(id,blah,this_person)
VALUES (1,'fred',ROW('a','b','c'));

SELECT (this_person).name FROM some_table;