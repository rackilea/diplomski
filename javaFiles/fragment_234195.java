CREATE OR REPLACE TRIGGER TRG_User_Roles_BRI
       BEFORE INSERT
       ON User_Roles
       REFERENCING NEW AS NEW OLD AS OLD
       FOR EACH ROW
    BEGIN
       :NEW.role_ID   := seq_user_roles.NEXTVAL;
    END;