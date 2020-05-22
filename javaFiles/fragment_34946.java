CREATE USER 'dbAdminUser'@'localhost' IDENTIFIED BY 'myPassword';
CREATE USER 'dbAdminUser'@'127.0.0.1' IDENTIFIED BY 'myPassword';
CREATE USER 'dbAdminUser'@'%' IDENTIFIED BY 'myPassword';

GRANT ALL ON *.* TO 'dbAdminUser'@'localhost';
GRANT ALL ON *.* TO 'dbAdminUser'@'127.0.0.1';
GRANT ALL ON *.* TO 'dbAdminUser'@'%';