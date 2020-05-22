CREATE TABLE `goods_log` (
    `revision` INT NOT NULL AUTO_INCREMENT,
    `id` INT NOT NULL,
    `name` varchar NOT NULL,
    `cost` DECIMAL NOT NULL,
    `user` varchar NOT NULL,
    `timestamp` DATETIME NOT NULL,
    PRIMARY KEY (`revision`,`id`)
);