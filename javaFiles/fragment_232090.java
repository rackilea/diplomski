CREATE OR REPLACE PACKAGE xx_bal_api
AS
   TYPE challan_rec IS RECORD
   (
      challan_number   VARCHAR2 (40),
      challan_amount   NUMBER
   );

   TYPE rec IS TABLE OF challan_rec index by pls_integer;

   FUNCTION get_challan (foo NUMBER)
      RETURN rec;
END;
/
CREATE OR REPLACE PACKAGE BODY xx_bal_api
AS
   FUNCTION get_challan (foo NUMBER)
      RETURN rec
   IS
      cr   rec;
   BEGIN
      cr (1).challan_number := '00002154215';
      cr (1).challan_amount := foo;
      RETURN cr;
   END get_challan;
END;