SQL> create table mac
  2    (state number,
  3     rpd varchar2(2),
  4     mac_address varchar2(20) constraint uk_mac unique,
  5     total_count number
  6    );

Table created.

SQL> insert into mac
  2    select 26, 'aa', 'aa:bb:12:cc:ab:aa', 1 from dual union
  3    select 26, 'bb', 'aa:bb:12:cc:ab:ab', 1 from dual union
  4    select 26, 'cc', 'aa:bb:12:cc:ab:ac', 1 from dual;

3 rows created.