/* file.txt needs to be in the same folder as the database
   first line of file is a header, others lines are data
--start file.txt
Col1|Col2|Col3
abcdef|My Company Name|0
--end file.txt
*/

--create the schema
create schema imp;

--create the normal table
create cached table imp.normalTable (
       Col1 char(6),
       Col2 nvarchar(200),
       Col3 int
);

--create the table that table
create text table imp.textfiletable (
       Col1 char(6),
       Col2 nvarchar(200),
       Col3 int
);

--setup the text file table
set table imp.textfiletable source "file.txt;ignore_first=true;fs=|";

--insert data from text file into the `normal` table
INSERT INTO imp.normalTable (Col1, Col2, Col3) select Col1, Col2, Col3 from imp.textfiletable;

--we are done with the text file table
drop table imp.textfiletable;
commit;