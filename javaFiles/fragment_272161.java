CREATE OR REPLACE FUNCTION usersList()
RETURNS TABLE(at varchar,name varchar,surname varchar)  AS $$
    BEGIN
        RETURN QUERY SELECT * FROM users;
    END;
$$ LANGUAGE plpgsql;