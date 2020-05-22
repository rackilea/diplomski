//Perform delete
select @@ROWCOUNT

if @@ROWCOUNT = 0
  //RAISE ERROR

BEGIN TRY
 //perform insert here 
END TRY
BEGIN CATCH
DECLARE @ErrorMessage NVARCHAR(4000);
DECLARE @ErrorSeverity INT;
DECLARE @ErrorState INT;

SELECT @ErrorMessage = ERROR_MESSAGE(),
       @ErrorSeverity = ERROR_SEVERITY(),
       @ErrorState = ERROR_STATE();

-- Use RAISERROR inside the CATCH block to return 
-- error information about the original error that 
-- caused execution to jump to the CATCH block.
RAISERROR (@ErrorMessage, -- Message text.
           @ErrorSeverity, -- Severity.
           @ErrorState -- State.
           );

END CATCH;