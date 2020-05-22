create table "user" (
  user_id serial primary key,
  ...
);
create table meal (
  meal_id serial primary key,
  user_id int not null references "user"(user_id),
  ...
);