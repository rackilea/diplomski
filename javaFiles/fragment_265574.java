SQL> ed
Wrote file afiedt.buf

  1  declare
  2    -- Nested table
  3    type date_nt is table of date;
  4    -- Associative array
  5    type date_aa is table of date index by pls_integer;
  6    -- VArray
  7    type date_va is varray(2) of date;
  8    l_date_nt date_nt := date_nt( sysdate, sysdate );
  9    l_date_va date_va := date_va( sysdate, sysdate );
 10    l_date_aa date_aa;
 11  begin
 12    l_date_aa(1) := sysdate;
 13    l_date_aa(100) := sysdate;
 14* end;
 15  /

PL/SQL procedure successfully completed.