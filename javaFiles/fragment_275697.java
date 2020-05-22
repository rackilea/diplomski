create table users (
    id bigint primary key ,
    plan character varying,
    trades_today int
);

insert into users (id, plan, trades_today)
values (1, 'diamond', 15),
       (2, 'silver', 5),
       (3, 'gold', 0);

with packages(package_type, max_hits) as (
    values ('diamond', 20),
           ('platinum', 15),
           ('gold', 10),
           ('silver', 5)
)

select u.id, trades_today < p.max_hits
from users u
inner join packages p on u.plan = p.package_type;