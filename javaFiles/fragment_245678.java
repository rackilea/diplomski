Insert into tvfrequent (no, frequent1, frequent1x, frequent2x, frequent2, frequent3, frequent4, frequent5, support)
SELECT no,
SUBSTRING_INDEX( unixdatetime , ' ', 1 ) AS frequent1,                   
concat
      (
       SUBSTRING_INDEX(SUBSTRING_INDEX( unixdatetime , ' ', 2 ),' ',-1)
       ,
       " "
       ,
       SUBSTRING_INDEX(SUBSTRING_INDEX( unixdatetime , ' -1 ', 2 ),' -1 ',-1)      
      ) As frequent2,
SUBSTRING_INDEX(SUBSTRING_INDEX( unixdatetime , ' -1 ', 3 ),' -1 ',-1) AS frequent3,
SUBSTRING_INDEX(SUBSTRING_INDEX( unixdatetime , ' -1 ', 4 ),' -1 ',-1) AS frequent4,
SUBSTRING_INDEX(SUBSTRING_INDEX( unixdatetime , ' -1 ', 5 ),' -1 ',-1) AS frequent5,
SUBSTRING_INDEX( unixdatetime , ' -1 ', -1 ) AS support
FROM tspade;