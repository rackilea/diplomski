<sql:query var="p_anlage" 
    sql="INSERT INTO person (SV_NR, VORNAME, NACHNAME, STRASSE, HAUSNUMMER, ORT, POSTLEITZAHL) 
         VALUES (?, ?, ?, ?, ?, ?, ? );">
  <sql:param value="${param.svnr}"/>
  <sql:param value="${param.vorname}"/>
  <sql:param value="${param.nachname}"/>
  <sql:param value="${param.strasse}"/>
  <sql:param value="${param.hausnummer}"/>
  <sql:param value="${param.ort}"/>
  <sql:param value="${param.postleitzahl}"/>
</sql:query>