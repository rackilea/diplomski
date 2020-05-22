SQL> declare
  2    valuelist mynumbers := mynumbers(23,124,987,6123,8923,1,7139);
  3  begin
  4    for r in
  5    ( select ws.sheetid
  6        from worksheet ws
  7           , table(valuelist) vl
  8       where ws.sheetid = vl.column_value
  9    )
 10    loop
 11      dbms_output.put_line(r.sheetid);
 12    end loop;
 13  end;
 14  /
1
23
124
987
6123
7139
8923

PL/SQL procedure successfully completed.