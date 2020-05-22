SET @file_name = 'myfilename'
 ;

 LOAD DATA LOCAL INFILE '/home/datauser/Desktop/working/revenue_2016_10_06.csv'  
 INTO TABLE revenue_table  
 FIELDS TERMINATED BY ','   
 LINES TERMINATED BY '\n'  
 ( @total_rev
 , @monthly_rev
 , @day_rev
 )
 SET `total_rev`   = @total_rev
   , `monthly_rev` = @monthly_rev
   , `day_rev`     = @day_rev
   , `from`        = @file_name
 ;