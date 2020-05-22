CREATE TABLE word (
word_id UNSIGNED INTEGER AUTOINCREMENT PRIMARY KEY,
entry TEXT, 
pos VARCHAR(50)
);

CREATE TABLE translation (
translation_id UNSIGNED INTEGER AUTOINCREMENT PRIMARY KEY,
word_id UNSIGNED INTEGER,
lang VARCHAR(5),
entry TEXT
);

CREATE TABLE word_translation (
word_id UNSIGNED INTEGER, 
translation_id UNSIGNED INTEGER,
PRIMARY KEY (word_id, translation_id),
INDEX (word_id),
INDEX (translation_id),
FOREIGN KEY fk_word_id (word_id) REFERENCES word(id),
FOREIGN KEY fk_translation_id (translation_id) REFERENCES translation(id)
);