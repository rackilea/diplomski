SQL> WITH mytable AS
  2    (SELECT '"AB","P & Q","XY"' TEXT FROM DUAL
  3    )
  4  SELECT trim(regexp_substr(TEXT, '[^,]+', 1, LEVEL)) TEXT
  5  FROM mytable
  6    CONNECT BY LEVEL <= regexp_count(TEXT, ',')+1;

TEXT
-----------------
"AB"
"P & Q"
"XY"