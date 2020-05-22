Select . . .
from (select d.*,
             count(*) filter (where title = 'Black Butterfly') over () as cnt_bb
      from DVDs d
      where type = 'Movie'
     ) d 
where cnt_bb = 0 or title = 'Black Butterfly';