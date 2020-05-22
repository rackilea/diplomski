declare
   ccol clob;
   outs varchar2(2000);
begin
   select a into ccol from a1;
   outs := HelloWorldExample(dbms_lob.substr(ccol,500,1),'somestr1','somestr2');
   dbms_output.put_line(outs);
end;
/