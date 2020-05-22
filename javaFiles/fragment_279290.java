SQL> create sequence s1 start with 1000;

Sequence created.

SQL> create sequence s2 start with 6000;

Sequence created.

SQL> select to_char(s1.nextval)||'-'||to_char(s2.nextval) from dual;

TO_CHAR(S1.NEXTVAL)||'-'||TO_C
--------------------------------        
1000-6000

SQL> select to_char(s1.currval)||'-'||to_char(s2.nextval) from dual;

TO_CHAR(S1.CURRVAL)||'-'||TO_C
------------------------------        
1000-6001