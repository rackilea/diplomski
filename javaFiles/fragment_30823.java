CREATE TABLE cards ( next_date );

INSERT INTO cards SELECT 1234;
INSERT INTO cards SELECT '1234';

SELECT 'int', typeof( next_date ), next_date FROM cards WHERE next_date < 1234;
SELECT 'str', typeof( next_date ), next_date FROM cards WHERE next_date < '1234';