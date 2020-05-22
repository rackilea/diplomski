create table numTests
(   id int auto_increment primary key,
    d2 decimal(10,2) not null,
    d3 decimal(10,3) not null,
    myF float not null,
    myD double not null
);
insert numTests(d2,d3,myF,myD) values
(122.226,122.226,122.2223333,333.44444444); -- decimal place truncate on d2

insert numTests(d2,d3,myF,myD) values
(122.12,122.226,122.2223333,333.44444444); -- no truncate