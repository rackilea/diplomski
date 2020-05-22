insert into B(col)
  values(1);

insert into A(t1_id, col)
  values(last_insert_id(), 2);

insert into A(t1_id, col)
  values(last_insert_id(), 3);