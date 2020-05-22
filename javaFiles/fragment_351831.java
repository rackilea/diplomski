SQL> select * from mac;

     STATE RP MAC_ADDRESS          TOTAL_COUNT
---------- -- -------------------- -----------
        26 aa aa:bb:12:cc:ab:aa              1
        26 bb aa:bb:12:cc:ab:ab              1
        26 cc aa:bb:12:cc:ab:ac              1

SQL> exec p_mac(26, 'ab', 'aa:bb:12:cc:ab:ac');

PL/SQL procedure successfully completed.

SQL> select * From mac;

     STATE RP MAC_ADDRESS          TOTAL_COUNT
---------- -- -------------------- -----------
        26 aa aa:bb:12:cc:ab:aa              1
        26 bb aa:bb:12:cc:ab:ab              1
        26 cc aa:bb:12:cc:ab:ac              0
        26 ab aa:bb:12:cc:ab:ac              1

SQL>