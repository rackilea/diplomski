DECLARE user_id bigint;

SELECT `userid` INTO user_id FROM `transaction_properties`
WHERE `transaction_id` = CONNECTION_ID() LIMIT 1;

IF user_id IS NULL THEN
  SET user_id = -1;
END IF;