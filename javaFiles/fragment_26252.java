-- Set Mary as having attended M001 Basic maths
UPDATE attendance SET attended = 1 
    WHERE course_reference = (SELECT _id FROM course WHERE course_code = 
        'M001' -- value that would be changed to suit
    )
        AND person_reference = (SELECT _id FROM person WHERE name =
        'Mary Smith' -- value that would be changed to suit
        )
;
-- Letters after update
SELECT letter_to_send FROM non_attendance_list;