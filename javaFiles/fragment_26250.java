DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS attendance;
DROP VIEW IF EXISTS proposed_attendance_list;
DROP VIEW IF EXISTS non_attendance_list;

-- Create the role table
CREATE TABLE IF NOT EXISTS role (_id INTEGER PRIMARY KEY, role);
-- Add some roles
-- NOTE _id column is not specified so SQLite will assign a unqiue value 
-- assigned value will likely be 1, then likely 2, then likely 3........9,223,372,036,854,775,807 (highest)
-- NOTE no need for AUTOINCREMENT keyword and the resultant performance loss
-- NOTE _id is the column name that best suits Android (e.g. Cursor Adapters need this column name)
INSERT INTO ROLE (role) VALUES 
    ('Instructor'), -- id 1
    ('Student'), -- id 2
    ('Instructor Aid '), -- id 3
    ('Administrator') -- id 4
    -- !!!NOTE!!! you would not typically assume specific id
;

-- Create the Person table (Person will have a role - for simplicity of demo single role assumed)
CREATE TABLE IF NOT EXISTS person (_id INTEGER PRIMARY KEY, name TEXT, role INTEGER);

INSERT INTO person (name,role) VALUES
    ('Professor Plum',1), -- Instructor id = 1
    ('Tom Brown',2), -- Student id = 2
    ('Mary Smith',2), -- Student  id = 3
    ('Sue Barnes',2), -- Student id = 4
    ('Ty Pit',4), -- Admin id = 5
    ('Dr. J M Hardy',1), -- Instructor id = 6
    ('Matilda Dance',2), -- Student id = 7
    ('Fred Bloggs',3) -- Aid id = 8

;

CREATE TABLE IF NOT EXISTS course (
    _id INTEGER PRIMARY KEY, 
    course_name TEXT NOT NULL, 
    course_code TEXT NOT NULL, 
    course_hour TEXT NOT NULL, 
    course_minute TEXT, 
    course_time, 
    course_instructor INTEGER
);
INSERT INTO course (course_name, course_code, course_hour, course_minute, course_instructor) VALUES
    ('MATHS BASIC','M001','10','30',6), -- Maths with instructor Dr. J M Hardy id = 1
  ('MATHS APPLIED', 'M101','12','30',6), -- Applied Maths instructor Dr. J M Hardy id =2 
  ('MATHS ADVANCED','M011','11','00',1) -- Advanced Maths instructor Professor Plum id =3
;

CREATE TABLE IF NOT EXISTS attendance (course_reference INTEGER, person_reference INTEGER, attended INTEGER, PRIMARY KEY (course_reference, person_reference));
INSERT INTO attendance VALUES
    (1,6,0), -- Dr J M Hardy should attend (attended 0 = should attend, -1 if did not attend, 1 if did attend) course MATCHS BASIC
    (1,3,0), -- Mary Should attent Basic maths
    (1,7,0), -- Matilda should attend basic maths
    (1,8,0), -- Aid Fred should attend basic maths
    (3,1,1), -- Advanced maths Plum attended (taught it)
    (3,2,-1), -- Advanced maths Tom Brown missed
    (3,3,1), -- Advanced maths mary attended
    (3,8,1), -- Aid Fred attended
    (2,4,1), -- Applied Maths Sue attended
    -- (2,4,0) WOULD BE DUPLICATE SO NOT ALLOWED (INSERT OR IGNORE would skip, Note android SQliteDatabase insert method uses INSERT OR IGNORE)
    (2,3,0), -- Mary didn't attend as such but not flagged as did not attend (could just use 0 to indicate did not attend)
    (2,7,1), -- Applied Maths Matilda attended
    (2,6,0), -- Dr Hardy should attend
    (2,1,0), -- Prof Plum should attend
    (2,8,0) -- Fred Bloggs Admin should attend
;

-- Course attendace example listing the course details, the number of attendees and the list of attendees
-- Create as a view so that it can be resued (only need to type it out once)
CREATE VIEW IF NOT EXISTS proposed_attendance_list AS 
    SELECT 
        course.course_name, 
        course.course_code, 
        course.course_hour||':'||course.course_minute AS CourseTime, 
        count(attended) AS proposed_attendance, 
        group_concat(Person.name,' ,') AS peeople 
    FROM Course 
        JOIN attendance ON course._id = attendance.course_reference
        JOIN person ON attendance.person_reference = person._id
        JOIN role ON person.role = role._id
    -- GROUP BY course_hour, course_minute
    -- HAVING
    GROUP BY course_code
    ORDER BY course.course_code,role._id
;
-- Initial proposed course attendance
SELECT * FROM proposed_attendance_list;
-- Change some course codes
UPDATE course SET course_code = 'M201' WHERE course_code = 'M101';
UPDATE course SET course_code = 'M111' WHERE course_code = 'M011';
-- Modifed proposed course attendance
SELECT * FROM proposed_attendance_list;