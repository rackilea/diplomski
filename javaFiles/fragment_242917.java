CREATE OR REPLACE FUNCTION time_to_sec(timepoint timestamp with time zone)
  RETURNS bigint LANGUAGE plpgsql AS
$BODY$
DECLARE
 seconds bigint;
 secondsFromEpoch bigint;
 secondsFromMidnight bigint;
BEGIN
 secondsFromEpoch = EXTRACT(EPOCH FROM timepoint)::bigint;
 secondsFromMidnight = EXTRACT(EPOCH FROM CURRENT_TIMESTAMP::date)::bigint;
 seconds = secondsFromEpoch - secondsFromMidnight;
 return seconds;
END;
$BODY$;