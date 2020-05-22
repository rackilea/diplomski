select t.id, t.label, sum(views)
from video_tag as vt
inner join video as v on v.id = vt.video_id
inner join tag as t on t.id = vt.tag_id
group by t.id, t.label
;