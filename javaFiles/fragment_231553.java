SQL> create or replace function f_test (par_ename in types.char10)
  2    return types.num81
  3  is
  4    retval number;
  5  begin
  6    select sal into retval
  7      from emp
  8      where ename = par_ename;
  9    return retval;
 10  end;
 11  /

Function created.