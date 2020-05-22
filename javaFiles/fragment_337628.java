create table language_codes
(
   iso3 text not null primary key,
   iso2 text not null unique, 
   country_name text not null
);