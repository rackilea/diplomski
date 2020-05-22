CREATE TABLE shiftdata (
    id int,
    foodcost int,
    officesuppl int,
    repmaint int,
    netsales int,
    salestax int);

CREATE TABLE otherpaidouts (
    id int,
    shiftid int,
    label varchar(20),
    amount int);

CREATE TABLE discounts (
    id int,
    shiftid int,
    itemname varchar(20),
    amount int);