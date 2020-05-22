create external table mytable
(
    ts          timestamp
   ,word1       string
   ,word2       string
   ,word3       string
   ,word4       string
   ,word5       string
   ,word6       string
   ,word7       string
   ,word8       string
   ,word9       string
)
row format delimited
fields terminated by '\t'
stored as textfile
;