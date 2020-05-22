SELECT 
    db, name, type, param_list, returns, body
FROM
    mysql.proc
WHERE
    TYPE = 'PROCEDURE' OR TYPE = 'FUNCTION';