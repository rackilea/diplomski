CREATE TYPE daut_addresses_port_type AS OBJECT (
  address VARCHAR2(50),
  port number
)
/

CREATE TYPE daut_addresses_port_tab_type AS TABLE OF daut_addresses_port_type
/

CREATE OR REPLACE PACKAGE daut_2fa IS

  FUNCTION GatewayClientPoolHA (
      DAUTAddressesAndPorts IN daut_addresses_port_tab_type,
      sslKeystorePath       IN VARCHAR2,
      sslKeystorePass       IN VARCHAR2
 ) RETURN NUMBER;

END daut_2fa;
/

CREATE OR REPLACE PACKAGE BODY daut_2fa IS

  FUNCTION GatewayClientPoolHA (
      DAUTAddressesAndPorts IN daut_addresses_port_tab_type,
      sslKeystorePath       IN VARCHAR2,
      sslKeystorePass       IN VARCHAR2
 ) RETURN NUMBER IS LANGUAGE JAVA
   NAME 'daut.GatewayClientPoolHA(oracle.sql.STRUCT[], java.lang.String, java.lang.String) return int';

END daut_2fa;
/