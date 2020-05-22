SELECT
    rqTime, name, lastName, requestVar
INTO
    time, fName, lName, rVar
FROM pdata.userlist;
-- Probably you need a WHERE or another statement to make sure you only retrieve 1 row as result
-- Otherwise, this stored procedure will fail