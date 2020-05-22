CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL AUTO_INCREMENT, // use INTEGER NOT NULL for SQLite
  `uuid` VARCHAR ( 64 ) NOT NULL,
  `name` VARCHAR ( 32 ) NOT NULL,
  `date` BIGINT NULL,
  CONSTRAINT `uuid_date` UNIQUE ( `uuid`, `date` ),
  PRIMARY KEY ( `id` )
);