Create schema TestDB;

CREATE TABLE EMPLOYEE
(
    ID INT,
    NAME Varchar(100),
    DEPARTMENT INT,
    EMAIL Varchar(100)
);

INSERT INTO EMPLOYEE VALUES (1,'Anish',101,'anish@howtodoinjava.com');
INSERT INTO EMPLOYEE VALUES (2,'Lokesh',102,'lokesh@howtodoinjava.com');
INSERT INTO EMPLOYEE VALUES (3,'Rakesh',103,'rakesh@howtodoinjava.com');
INSERT INTO EMPLOYEE VALUES (4,'Yogesh',104,'yogesh@howtodoinjava.com');

--These are the duplicate rows

INSERT INTO EMPLOYEE VALUES (5,'Anish',101,'anish@howtodoinjava.com');
INSERT INTO EMPLOYEE VALUES (6,'Lokesh',102,'lokesh@howtodoinjava.com');