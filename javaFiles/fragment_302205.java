CREATE OR REPLACE FUNCTION update_timestamp() RETURNS TRIGGER AS 
$update_timestamp$
    BEGIN
        NEW.mdate := CURRENT_TIMESTAMP;
        RETURN NEW;
    END;
$update_timestamp$ 
LANGUAGE plpgsql;

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON avatars
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON users
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();