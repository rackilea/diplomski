CREATE TABLE AUTHOR (
    "ID" INTEGER primary key auto_increment,
    "FIRSTNAME" VARCHAR(50) not null,
    "SECONDNAME" VARCHAR(50) not null
);

CREATE TABLE BOOK (
    "ID" INTEGER primary key auto_increment,
    "TITLE" VARCHAR(50) not null,
    "AUTHOR" INTEGER, FOREIGN KEY ("AUTHOR") REFERENCES AUTHOR("ID")
);