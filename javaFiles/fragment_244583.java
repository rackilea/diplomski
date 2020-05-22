CREATE TABLE junction (
  id     INT          NOT NULL,
  a_id   INT         NOT NULL,
  b_id   INT         NOT NULL,
  CONSTRAINT junction_fk_a FOREIGN KEY (a_id) REFERENCES entityA (id),
  CONSTRAINT junction_fk_b FOREIGN KEY (b_id) REFERENCES entityB (id)
);