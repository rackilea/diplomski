CREATE OR REPLACE FUNCTION time_to_sec2(timepoint timestamp with time zone)
  RETURNS bigint LANGUAGE plpgsql STABLE AS
$BODY$
BEGIN
    RETURN EXTRACT(EPOCH FROM timepoint - current_date)::bigint;
END;
$BODY$;