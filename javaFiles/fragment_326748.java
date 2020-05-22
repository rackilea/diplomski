CREATE TABLE employee
(
  eid text,
  ename text,
  esalary text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE employee
  OWNER TO postgres;