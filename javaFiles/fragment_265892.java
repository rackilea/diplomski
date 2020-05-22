-- In Pg 9.1 and above; for older versions hstore is available but is
-- added differently. See the documentation.
CREATE EXTENSION hstore;

CREATE TABLE some_table (id integer primary key, blah text, this_person hstore);

INSERT INTO some_table(id,blah,this_person)
VALUES (1,'fred', hstore(ARRAY['name','surname','miatso'], ARRAY['a','b','c']));

SELECT this_person -> 'name' from some_table ;