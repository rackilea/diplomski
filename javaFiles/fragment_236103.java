CREATE FUNCTION del_obj() RETURNS trigger AS $$
BEGIN
  UPDATE obj SET is_deleted = true WHERE id = OLD.id;
  UPDATE subobj SET is_deleted = true WHERE obj_id = OLD.id;
  RETURN NULL; -- fail the delete operation
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER tr_del_obj
  BEFORE DELETE ON obj
  FOR EACH ROW EXECUTE PROCEDURE del_obj();