-- Database code --

CREATE TABLE project_types (
  proj_id VARCHAR2(10),
  proj_title VARCHAR2(10)
);
/

CREATE OR REPLACE TYPE project_type AS OBJECT ( 
  proj_id VARCHAR2(10),
  proj_title VARCHAR2(10)
);
/

CREATE OR REPLACE TYPE my_array AS TABLE OF project_type;
/

CREATE OR REPLACE PROCEDURE add_projects(p_projects_array IN my_array)
AS
BEGIN
  IF p_projects_array IS NOT NULL THEN
    FOR v_i IN 1..p_projects_array.LAST
    LOOP
      INSERT INTO project_types
        VALUES (p_projects_array(v_i).proj_id,
                p_projects_array(v_i).proj_title);
    END LOOP;
  END IF;
END;
/