begin
  update CONTROL_TABLE set status='W' where status = 'U'
  returning REF_NO
  bulk collect into ?;
  commit;
end;
/