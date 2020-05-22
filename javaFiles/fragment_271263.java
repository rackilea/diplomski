create or replace procedure MANAGE_DOCUMENT(
  pSomeParam IN someTable.someColumn%TYPE,#if we need some param.
  pError OUT VARCHAR2
  )IS
  vResult BLOB;
  vDoc CLOB;

  begin
    pError := '';

    #extract base64 document
    SELECT EXTRACT(myColumn, 'xPath/to/the/element/text()').getClobVal()
    into vDoc
    FROM myTable WHERE someCondition;

    #check if doc exists
    IF vDoc IS NULL THEN
      pError :='Document not found';
    ELSE
      #decode and get blob
      vResult := utl_raw.cast_to_raw(vDoc);
      #do inserts or whatever        
      END IF;
    END IF; 
end MANAGE_DOCUMENT;