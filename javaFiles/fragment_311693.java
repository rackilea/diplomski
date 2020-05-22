mysql> INSERT INTO route_table (SYSTEM, IP, PORT) VALUES ("192.168.1.24:8080","192.168.1.24","8080") ON DUPLICATE KEY UPDATE IP=values(IP) AND PORT=values(PORT);
Query OK, 1 row affected (0.04 sec)

mysql> INSERT INTO route_table (SYSTEM, IP, PORT) VALUES ("192.168.1.24:8080","192.168.1.24","8080") ON DUPLICATE KEY UPDATE IP=values(IP) AND PORT=values(PORT);
ERROR 1292 (22007): Truncated incorrect DOUBLE value: '192.168.1.24'
mysql>