CREATE OR REPLACE PROCEDURE my_proc (idvalue      NUMBER,
    imagedata     tobedeleted.img%TYPE
                                                )
IS
BEGIN
    INSERT INTO tobedeleted
      VALUES   (idvalue, imagedata
                  );
END my_proc;