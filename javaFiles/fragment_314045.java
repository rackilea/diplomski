LOAD DATA LOCAL INFILE '/home/datauser/Desktop/working/revenue_2016_10_06.csv'  
 INTO TABLE revenue_table  
 FIELDS TERMINATED BY ','   
 LINES TERMINATED BY '\n'  
 (total_rev,monthly_rev,day_rev)

 SET `from` = 'file1'
 ;