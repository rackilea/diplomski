DROP TABLE IF EXISTS `test`.`company_person`;
DROP TABLE IF EXISTS `test`.`employment_record`;
DROP TABLE IF EXISTS `test`.`company`;
DROP TABLE IF EXISTS `test`.`person`;

CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '',
  `address` varchar(500) DEFAULT '',
  `version_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '',
  `address` varchar(500) DEFAULT '',
  `version_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Join table */
CREATE TABLE `company_person` (
  `company_id` int NOT NULL,
  `person_id` int NOT NULL,
  PRIMARY KEY (`person_id`,`company_id`),
  KEY `company_idx` (`company_id`),
  KEY `person_idx` (`person_id`),
  CONSTRAINT `fk_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Employment records */
CREATE TABLE `employment_record` (
  `company_id` int NOT NULL,
  `person_id` int NOT NULL,
  `start_date` datetime,
  `end_date` datetime,
  `version_id` int NOT NULL,
  PRIMARY KEY (`person_id`,`company_id`),
  KEY `empl_company_idx` (`company_id`),
  KEY `empl_person_idx` (`person_id`),
  CONSTRAINT `fk_empl_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_empl_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB DEFAULT CHARSET=utf8;