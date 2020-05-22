CREATE OR REPLACE EDITIONABLE PACKAGE BODY "TEST_PACKAGE" AS

  PROCEDURE PerformersRole(P_ID Number) AS

    LV_Performer_Map MAP_VARCHAR
  BEGIN
    LV_Performer_Map MAP_VARCHAR= GET_MAP_VARCHAR(P_PROCESS_ID NUMBER);

        DBMS_OUTPUT.PUT_LINE('Hello ' || LV_Performer_Map('Engineer'));

  END PerformersRole;