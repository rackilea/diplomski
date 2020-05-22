START TRANSACTION
INSERT INTO messages(`message`) VALUES ('message1');
@message1:=last_insert_id();
INSERT INTO messages_tags(`message_id`, `tags`) VALUES (LAST_INSERT_ID(), 'tagfoo1');
@message2:=last_insert_id();
INSERT INTO messages_tags(`message_id`, `tags`) VALUES (LAST_INSERT_ID(), 'tagbar1');
@message3:=last_insert_id();
INSERT INTO messages(`message`) VALUES ('message2');
INSERT INTO messages_tags(`message_id`, `tags`) VALUES (LAST_INSERT_ID(), 'tagfoo1');
@message4:=last_insert_id();
INSERT INTO messages(`message`) VALUES ('message3');
INSERT INTO messages_tags(`message_id`, `tags`) VALUES (LAST_INSERT_ID(), 'tagfoo2');
@message5:=last_insert_id();
...
COMMIT