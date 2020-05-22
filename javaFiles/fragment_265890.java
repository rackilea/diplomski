CREATE TABLE some_table (id integer primary key, blah text, this_person xml);

INSERT INTO some_table(id,blah,this_person)
VALUES (1,'fred', '<person><name>a</name><surname>b</surname><miasto>c</miasto></person>');

SELECT (xpath('/person/name/text()', this_person))[1] from some_table ;