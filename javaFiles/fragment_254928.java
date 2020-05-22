DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS organization_address;

CREATE TABLE account (
  account_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  organization_name VARCHAR(45) NOT NULL,
  account_type VARCHAR(10) NOT NULL,
  organization_address_id SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY  (account_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE organization_address (
  organization_address_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  address VARCHAR(45) NOT NULL,
  city VARCHAR(45) NOT NULL,
  state VARCHAR(45) NOT NULL,
  country VARCHAR(45) NOT NULL,
  PRIMARY KEY  (organization_address_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO organization_address VALUES(1, '123 Foo St.', 'Foo City', 'Texas', 'USA');
INSERT INTO organization_address VALUES(2, '456 Bar St.', 'Bar City', 'Arizona', 'USA');
INSERT INTO organization_address VALUES(3, '789 Quux Ave.', 'Quux City', 'New Mexico', 'USA');

INSERT INTO account VALUES(1, 'Foo',  'Type1', 1);
INSERT INTO account VALUES(2, 'Bar',  'Type1', 2);
INSERT INTO account VALUES(3, 'Quux', 'Type2', 3);

DROP PROCEDURE IF EXISTS Get_AccountList;

DELIMITER $$

CREATE PROCEDURE Get_AccountList(IN p_account_type VARCHAR(10))
READS SQL DATA
BEGIN
     SELECT a.account_id, a.organization_name, o.state
     FROM account a
     JOIN organization_address o ON a.organization_address_id = o.organization_address_id
     WHERE account_type = p_account_type
     ORDER BY a.account_id;
END $$

DELIMITER ;