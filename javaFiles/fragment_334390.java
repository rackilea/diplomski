insert into actor (first_name,last_name) values ('ADELIN','NO_PHANTOM');
insert into actor (first_name,last_name) values ('BELA','REPEATABLE_READ');

transaction 1:
select * from actor; 
-- ADELIN|NO_PHANTOM
-- BELA  |REPEATABLE_READ

transaction 2:
delete from actor where last_name = 'REPEATABLE_READ';
commit;

transaction 1:      
select * from actor;  -- still the same 
-- ADELIN|NO_PHANTOM
-- BELA  |REPEATABLE_READ

update actor set last_name = '';

select * from actor;  -- the deleted row stays unchanged
-- ADELIN|
-- BELA  |REPEATABLE_READ