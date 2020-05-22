alter session set nls_sort = 'BINARY';

SELECT
    CASE
      WHEN regexp_instr(messages.NR, '[a-z]{2}[[:space:],_-]\d+[-_]\d{2,6}') > 0
      THEN regexp_substr(messages.NR, '\d+')
      ELSE messages.NR
    END AS message_id
  FROM
    ( SELECT 'GB 28647854-04' AS NR FROM dual
    UNION
    SELECT 'GB 5310031-05' AS NR FROM dual
    UNION
    SELECT '9184' AS NR FROM dual
    ) messages;

MESSAGE_ID   
--------------
9184          
GB 28647854-04
GB 5310031-05