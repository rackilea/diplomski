create sequence sequencer;
create table "user" (
  user_id int primary key default nextval('sequencer'),
  ...
);
create table meal (
  meal_id int primary key default nextval('sequencer'),
  user_id int not null references "user"(user_id),
  ...
);