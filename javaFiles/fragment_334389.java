insert into actor (first_name,last_name) values ('ADELIN','NO_PHANTOM');

transaction 1:
select * from actor;
-- ADELIN|NO_PHANTOM

transaction 2:
insert into actor (first_name,last_name) values ('BELA','PHANTOM_READ');
commit;

transaction 1:
select * from actor;  -- still the same
-- ADELIN|NO_PHANTOM

update actor set last_name = 'PHANTOM READ'
where last_name = 'PHANTOM_READ';

select * from actor;  -- now includes the new, updated row
-- ADELIN|NO_PHANTOM
-- BELA  |PHANTOM READ