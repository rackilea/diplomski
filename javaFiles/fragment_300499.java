PROCEDURE getLogs (
    p_idcontract            IN          NUMBER,
    p_iduser                IN          NUMBER,
    p_recordset OUT SYS_REFCURSOR
  )
  IS   
  BEGIN
 OPEN p_recordset FOR
      SELECT logData 
      FROM SERVICELOG 
      WHERE IDCONTRACT= p_idcontract 
      AND IDUSER= p_iduser;

  END getLogs;