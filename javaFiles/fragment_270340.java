[REMOVED COMMENT]

CREATE OR REPLACE PROCEDURE "MAIL_WITH_ATTACHMENT" ( ) 
IS    
tmp varchar(2) ; [REMOVED COMMENT]
tmp1 varchar(2) := 'some texxt'; [REMOVED COMMENT]
tmp2 varchar(3) := 'some more --text'; [REMOVED COMMENT]
tmp3 varchar(4) := 'this regex isn''t --working properly'; [REMOVED COMMENT]
BEGIN

          '--This is a Mime message, which your current mail reader may not' || crlf ||
          ' some more -- characters in a string';

    mesg:= crlf ||
          '--This is a Mime message, which your current mail reader may not' || crlf ||
      ' some more -- characters in a string';
END;