select  ts

from    mytable

where   substr(lpad(conv(split(words,'\\t')[0],16,2),16,'0'),7,2) = '10'
;