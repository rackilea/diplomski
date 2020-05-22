-- remporary table
create table yourdb.tmp_textfiletable (col1 varchar(250));  

set table yourdb.tmp_textfiletable 
    source "'E:/Thesis/ThesisWork/outdata/keywords.txt';ignore_first=false";

-- And insert it in your normal table:

INSERT INTO yourdb.keywordsTable (keywords) 
    select Col1 from yourdb.tmp_textfiletable;

-- after that you can drop it

drop table yourdb.tmp_textfiletable