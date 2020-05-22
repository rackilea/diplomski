SQL> set timing on
SQL> declare
  2    v_id     number;
  3    v_filler varchar2(1000);
  4  begin
  5    for i in 1 .. 10000
  6    loop
  7      select *
  8        into v_id, v_filler
  9        from mytable
 10       where id = 1
 11      ;
 12      select *
 13        into v_id, v_filler
 14        from mytable
 15       where id = 2
 16      ;
 17      select *
 18        into v_id, v_filler
 19        from mytable
 20       where id = 3
 21      ;
 22      select *
 23        into v_id, v_filler
 24        from mytable
 25       where id = 4
 26      ;
 27    end loop;
 28  end;
 29  /

PL/SQL procedure successfully completed.

Elapsed: 00:00:01.03
SQL> /

PL/SQL procedure successfully completed.

Elapsed: 00:00:01.00
SQL> /

PL/SQL procedure successfully completed.

Elapsed: 00:00:00.99
SQL> declare
  2    v_id     number;
  3    v_filler varchar2(1000);
  4  begin
  5    for i in 1 .. 10000
  6    loop
  7      for r in (select * from mytable where id in (1,2,3,4))
  8      loop
  9        v_id := r.id;
 10        v_filler := r.filler;
 11      end loop;
 12    end loop;
 13  end;
 14  /

PL/SQL procedure successfully completed.

Elapsed: 00:00:00.41
SQL> /

PL/SQL procedure successfully completed.

Elapsed: 00:00:00.39
SQL> /

PL/SQL procedure successfully completed.

Elapsed: 00:00:00.39
SQL> set timing off