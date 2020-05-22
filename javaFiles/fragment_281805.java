SELECT 
        COUNT(Field_1) as field1, 
        COUNT(Field_2) as field2,
        timeInterval
 FROM (
    SELECT 
        Field_1,
        Field_2,
        FLOOR( TO_NUMBER( TO_CHAR( Time_Stamp, 'hhmi' ) ) / @INTERVAL ) as timeInterval
    FROM T
    WHERE Time_Stamp BETWEEN @DATE1 AND @DATE2
) 
GROUP BY timeInterval
ORDER BY timeInterval ASC;