SQL> create or replace TYPE tableOneExample AS OBJECT (
  2        somethingOne                 VARCHAR2 (4)
  3       ,somethingTwo        NUMBER (12)
  4  );
  5  /

Type created.

SQL> create or replace TYPE outputOneSQLType IS TABLE OF tableOneExample;
  2  /

Type created.

SQL>
SQL> create or replace PROCEDURE myprocedure (
  2  inputParam                IN       VARCHAR2,
  3  outputOne                 OUT outputOneSQLType)
  4  as
  5  begin
  6  outputOne  := outputOneSQLType(tableOneExample('a', 1), tableOneExample('b', 2));
  7  end;
  8  /

Procedure created.