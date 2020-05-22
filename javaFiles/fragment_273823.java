d1 = LOAD 'data' USING com.twitter.elephantbird.pig.load.JsonLoader('-nestedLoad') AS (json:map[]); 

d2 = foreach d1 generate 
    json#'event' AS EVENT,
    json#'params'#'uid' AS USER, 
    ToDate(((long)json#'ts')*1000) AS DATE;  

grpd = group d2 by EVENT;

 uniq2 = foreach grpd { 
 usr = d2.USER; 
 unq_usr = distinct usr; 

 generate group, 
   d2.DATE, 
   COUNT(d2.EVENT),  
   COUNT(unq_usr);  
};