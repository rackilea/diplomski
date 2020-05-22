-- in Pg 9.2 and above; for 9.1 use the json91 backport
CREATE EXTENSION json;

CREATE TABLE some_table (id integer primary key, blah text, this_person json);

INSERT INTO some_table(id,blah,this_person)
VALUES (1,'fred', '{"name": "a", "surname":"b", "miasto":"c"}');

-- No easy way to subscript out json values in 9.1, but it's very convenient
-- with any app that has json support.