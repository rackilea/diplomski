FUN_BODY = """CREATE FUNCTION abs_eq (arg1 INTEGER, arg2 INTEGER) RETURNING BOOLEAN;
    IF (arg1 == arg2) THEN
        RETURN 't';
    END IF;
    IF (arg1 == -arg2) THEN
        RETURN 't';
    END IF;
    IF (-arg1 == arg2) THEN
        RETURN 't';
    END IF;
    RETURN 'f';
END FUNCTION;
"""