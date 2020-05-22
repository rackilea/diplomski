DELIMITER //
CREATE PROCEDURE temp ( empId INT)
    BEGIN
     DECLARE var_etype VARCHAR(36);

SELECT 
    emptype = QOUTE(emptype)
FROM
    dms_document
WHERE
    id = empid;
SELECT 
    emptype,
    CASE
        WHEN emptype = 'P' THEN doctype
        ELSE 'No Documents required'
    END
FROM
    dms_report
WHERE
    pilot = 1;
End//
DELIMITER ;