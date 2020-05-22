Use [MyDatabase]; 
     CREATE PROCEDURE [MyDB].[SEND_EMAIL_DB] 
       @profile_name2 varchar(max), 
       @recipients2 varchar(max), 
       @body2 varchar(max), 
       @body_format2 varchar(max), 
       @subject2 varchar(max), 
       @p_result int OUTPUT 
     AS 
       BEGIN  
          exec msdb.dbo.sp_send_dbmail  @profile_name=@profile_name2,
                   @recipients=@recipients2,@body=@body2,
                   @body_format=@body_format2,@subject=@subject2 
       END