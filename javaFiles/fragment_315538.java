CREATE TYPE StringList IS TABLE OF VARCHAR2(255)
/

CREATE PACKAGE SOLICITUDES_HTTP AS
  FUNCTION Solicitud_Http_get(
    header_keys   IN StringList,
    header_values IN StringList,
    url           IN VARCHAR2
  ) return VARCHAR2;
END SOLICITUDES_HTTP;
/

CREATE PACKAGE BODY SOLICITUDES_HTTP AS
  FUNCTION Solicitud_Http_get(
    header_keys   IN StringList,
    header_values IN StringList,
    url           IN VARCHAR2
  ) return VARCHAR2
  IS LANGUAGE JAVA
    NAME 'HTTP_Request.sendGet(java.lang.String[],java.lang.String[],java.Lang.String) return java.lang.String';
END SOLICITUDES_HTTP;
/