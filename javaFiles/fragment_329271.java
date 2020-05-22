drop TABLE  if EXISTS  stock;
CREATE TABLE stock(stock_id INT ,company_name VARCHAR(20),price DECIMAL (10,2)
);

INSERT INTO stock VALUES (1,'apple',345.01);
INSERT INTO stock VALUES (2,'google',8999.00);
INSERT INTO stock VALUES (3,'kashky',56.60);