create external table mytable
(
    ts          timestamp
   ,words       string
)
row format delimited
fields terminated by '\t'
stored as textfile
tblproperties ('serialization.last.column.takes.rest'='true')
;