List dtos = s.createSQLQuery(
"SELECT " + 
"   ERRORS.DMN_NAM AS dmnNam, " + 
"   CODES.MSG_TXT AS msgTxt " +
"FROM SERV_ERR ERRORS, EVENT_CD CODES " + 
"WHERE ERRORS.SERV_RESP_CD_TXT = CODES.CD_TXT " + 
"GROUP BY " + 
"   ERRORS.DMN_NAM, " + 
"   ERRORS.SERV_NAM, " + 
"   CODES.MSG_TXT, " + 
"   ERRORS.SERV_ERR_CNT, " + 
"   ERRORS.ERR_TS_NUM " +
"ORDER BY " + 
"   ERRORS.DMN_NAM, " + 
"   CODES.MSG_TXT "
  .addScalar("dmnNam")
  .addScalar("msgTxt")
  .setResultTransformer( Transformers.aliasToBean(MyDTO.class))
  .list();