PROCEDURE get_User_name
( user_id_in IN user.user_id%TYPE, 
  user_name_out OUT user.user_name%TYPE,
  user_ssn_out  out user.ssn_type%TYPE ) IS

BEGIN

SELECT c.user_name, c.ssn 
  INTO user_name_out, ssn_out
  FROM user c
  WHERE c.user_id = user_in;

END get_user_name;