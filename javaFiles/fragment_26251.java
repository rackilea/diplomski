CREATE VIEW IF NOT EXISTS non_attendance_list AS
    SELECT course_name, 
        course_code, 
        Person.name, 
        Person.role, 
        'Dear '||person.name||' our records show that you did''t attend Course '||course_code||' '||course_name||' rest of letter' AS letter_to_send
    FROM attendance
        JOIN course ON course_reference = course._id
        JOIN Person ON person_reference = Person._id
        JOIN Role ON Person.role = role._id
    WHERE attendance.attended < 1
    ORDER BY course_code
;

-- Initial letters
SELECT letter_to_send FROM non_attendance_list;