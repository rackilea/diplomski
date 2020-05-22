hive (default)> show partitions country_par;
country=Brazil
country=Canada
country=USA

hive (default)> select * from country_par where country='Brazil';
4   Brazil
5   Brazil

hive (default)> select * from country_par where country='USA';
1   USA
3   USA
6   USA

hive (default)> select * from country_par where country='Canada';
2   Canada
7   Canada

hive (default)> select country,count(*) from country_par group by country;
Brazil  2
Canada  2
USA 3