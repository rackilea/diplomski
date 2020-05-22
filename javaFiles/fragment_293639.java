create database contacts;
create user contacts identified by 'contacts';
-- this next one is what you're probably missing.
grant all on contacts.* to 'contacts'@'%';
grant select on `mysql`.`proc` to 'contacts'@'%';
use contacts;