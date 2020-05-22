CREATE TABLE app_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username varchar(40),
    password varchar(40),
    email varchar(40),
    UNIQUE KEY (username),
    UNIQUE KEY (email)
);