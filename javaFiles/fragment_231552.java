SQL> create or replace package types as
  2    subtype char10 is varchar2(10);
  3    subtype num81  is number(8, 1);
  4  end types;
  5  /

Package created.