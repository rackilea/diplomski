CREATE FUNCTION shouldGetBonus (INT department_id, INT project_id) 
RETURNS boolean
DETERMINISTIC
BEGIN 
  DECLARE is_eligible boolean;
  SET is_eligible = -- eligible to get bonus
  RETURN is_eligible;
END$$