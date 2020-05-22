Expression event_count = cb.count(gpe);

q.select(cb.tuple( 
  gpe.<String>get("gameId"), 
  event_count,
  ... 
)); 

q.orderBy(cb.desc(event_count));