DROP TABLE IF EXISTS messages;
create table messages(
    message_id serial,
    message_text varchar(50) NOT NULL,
    next_message_id int
);