set serveroutput on
declare
  query varchar2(4000);
begin
  query := q'[
SELECT /*+ opt_param('_optimizer_cost_model','io') opt_param('optimizer_index_cost_adj',20) opt_param('optimizer_index_caching',65) PARALLEL(4)*/
T.field AS table_field
FROM your_table T
WHERE T.field = :var
/
]';
  dbms_output.put_line(query);
  execute immediate query;
end;
/