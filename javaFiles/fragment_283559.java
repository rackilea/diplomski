CREATE SEQUENCE registry_seq
    INCREMENT BY 3
    START WITH 37
    MINVALUE 21
    MAXVALUE 299
    CYCLE;

CREATE PROCEDURE get_next_registry_id() RETURNING VARCHAR(10) AS registry_id;

    DEFINE i INTEGER;
    DEFINE r VARCHAR(10);
    SELECT registry_seq.NEXTVAL INTO i FROM "informix".SysTables WHERE tabid = 1;

    LET r = "EXE" || i;

    RETURN r;

END PROCEDURE;

CREATE TEMP TABLE registry
(
    id              VARCHAR(10) NOT NULL UNIQUE,
    email           VARCHAR(64) NOT NULL UNIQUE,
    name            VARCHAR(64) NOT NULL UNIQUE
);

INSERT INTO registry VALUES('EXE1', 'email1@gmail.com', 'Name 1');
INSERT INTO registry VALUES('EXE5', 'email5@gmail.com', 'Name 5');
INSERT INTO registry VALUES('EXE14', 'email14@gmail.com', 'Name 14');
INSERT INTO registry VALUES('EXE15', 'email15@gmail.com', 'Name 15');

INSERT INTO registry VALUES(get_next_registry_id(), 'email' || registry_seq.currval || '@example.com', 'User ID ' || registry_seq.currval);
INSERT INTO registry VALUES(get_next_registry_id(), 'email' || registry_seq.currval || '@example.com', 'User ID ' || registry_seq.currval);
INSERT INTO registry VALUES(get_next_registry_id(), 'email' || registry_seq.currval || '@example.com', 'User ID ' || registry_seq.currval);

SELECT * FROM registry ORDER BY id;