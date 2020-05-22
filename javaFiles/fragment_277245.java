CREATE TABLE IF NOT EXISTS `store` (
  `store_id` INT NOT NULL AUTO_INCREMENT,
  `store_address` INT NOT NULL,
  -- ...
  PRIMARY KEY (`store_id`),
  CONSTRAINT `FK_STR_STR_ADR`
  FOREIGN KEY (`store_address`)
    REFERENCES `store_address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `store_address` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  -- ...
  PRIMARY KEY (`address_id`)
  -- the FK constraint does NOT go here
)
ENGINE = InnoDB;