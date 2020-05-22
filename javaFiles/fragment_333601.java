declare 
 l_cursor number := dbms_sql.open_cursor; 
 l_offset number := -1 ; 
begin 
  begin 
    dbms_sql.parse( l_cursor, :st, dbms_sql.native ); 
  exception when others then
   l_offset := dbms_sql.last_error_position;
  end;
dbms_sql.close_cursor( l_cursor );
  :off := l_offset;
end;