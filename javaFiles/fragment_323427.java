declare
  cursor tCursor is
    select ref_no from CONTROL_TABLE
        where status = 'U' for update of STATUS skip locked;
  array SYS.ODCIVARCHAR2LIST := new SYS.ODCIVARCHAR2LIST();
begin
  for tCursorRec in tCursor loop
    update CONTROL_TABLE set status='W' where current of tCURSOR;
    array.extend();
    array(array.count) := tCURSORREC.REF_NO;
  end loop;
  commit;
  ? := array;
end;