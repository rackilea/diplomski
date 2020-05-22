CREATE OR REPLACE FUNCTION sha512Hex(c CLOB) RETURN VARCHAR2 AS
LANGUAGE JAVA NAME 'DigestUtils.sha512Hex(java.sql.Clob) return java.lang.String';

desc sha512Hex

Argument Name  Type     In/Out Default 
-------------- -------- ------ ------- 
<return value> VARCHAR2 OUT    unknown 
C              CLOB     IN     unknown