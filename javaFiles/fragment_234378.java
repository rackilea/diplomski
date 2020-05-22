CREATE OR REPLACE FUNCTION getfaultcount(_bunoid integer, _faultcode integer, _downloadtime timestamp without time zone, _filterbitmap integer, _faulttype text)
  RETURNS refcursor AS
$BODY$
DECLARE mycurs refcursor;
BEGIN 
    OPEN mycurs FOR
    SELECT count(*) as faultcount, _downloadtime as downloadtime
    FROM    fs_fault f
        JOIN download_time d ON f.downloadtimeid = d.id
    WHERE   f.faultcode = _faultcode
        AND f.statusid IN(2, 4)
        AND d.downloadtime = _downloadtime
        AND d.bunoid = _bunoid 
    GROUP BY f.faultcode
    ;
    RETURN mycurs;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION getfaultcount(integer, integer, timestamp without time zone, integer, text) OWNER TO postgres;