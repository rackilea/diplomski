CREATE TABLE IF NOT EXISTS `store` (
  `store_id` INT NOT NULL AUTO_INCREMENT,
  -- ... no store_address ...
  PRIMARY KEY (`store_id`)
  -- ... no FK constraint here ...
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `store_address` (
  -- addresses do not have independent IDs:
  `store_id` INT NOT NULL,
  -- ...
  PRIMARY KEY (`store_id`),
  CONSTRAINT `FK_STR_STR_ADR`
  FOREIGN KEY (`store_id`)
    REFERENCES `store` (`store_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;