UPDATE 
  `Reporting_officers`  
SET
  `Manager_id` = NULL
WHERE Reporting_officers.`Manager_id` = 3;

UPDATE 
  `Reporting_officers`  
SET
  `Managre2_id` = NULL
WHERE `Managre2_id` = 3;


UPDATE 
  `Reporting_officers`  
SET
  User_id = 6 
WHERE `User_id` = 3;


UPDATE 
  `Reporting_officers` 
SET
  `Manager_id` = CASE WHEN Manager_id IS NULL  THEN 6 ELSE Manager_id END,
  `Managre2_id` = CASE WHEN Managre2_id IS NULL  THEN 6 ELSE Managre2_id END