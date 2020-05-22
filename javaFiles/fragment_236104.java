CREATE FUNCTION del_subobj() RETURNS trigger AS $$
BEGIN
  UPDATE subobj SET is_deleted = true WHERE id = OLD.id;
  DELETE FROM subobj WHERE parent_subobj = OLD.id;
  RETURN NULL; -- fail the delete operation
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER tr_del_subobj
  BEFORE DELETE ON subobj
  FOR EACH ROW EXECUTE PROCEDURE del_subobj();