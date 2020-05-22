create table post (
    id int not null auto_increment,
    text varchar(140),
    primary key id
);

create table tag (
   id int not null auto_increment,
   name varchar(80) not null,
   primary key id
);

create table post_tag (
   post_id int,
   tag_id int,
   primary key(post_id, tag_id),
   foreign key(post_id) references post(id),
   foreign key(tag_id) reference tag(id)
);