create table up_votes (
  note_id                        bigint not null,
  user_id                        varchar(255) not null,
  constraint pk_up_votes primary key (note_id, user_id))
;

create table down_votes (
  note_id                        bigint not null,
  user_id                        varchar(255) not null,
  constraint pk_down_votes primary key (note_id, user_id))
;