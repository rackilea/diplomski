CREATE TABLE your_table (
  start_time  TIMESTAMP,
  end_time    TIMESTAMP,
  difference  GENERATED ALWAYS AS ( end_time - start_time )
);

INSERT INTO your_table ( start_time, end_time )
SELECT SYSTIMESTAMP, SYSTIMESTAMP + INTERVAL '01:02:03' HOUR TO SECOND FROM DUAL;