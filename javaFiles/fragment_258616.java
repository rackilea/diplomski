goto launch

:launch
    SET CKI_HOME=.
    SET BIN_PATH=%CKI_HOME%\bin
    SET LIB_PATH=%CKI_HOME%\lib
    SET ETC_PATH=%CKI_HOME%\etc
    SET ITI_HOME=%BIN_PATH%\itis
    SET CLS_PATH=%ETC_PATH%\itis\;%ITI_HOME%\classes\
    SET CLS_PATH=%CLS_PATH%;%LIB_PATH%\gpl\*;%LIB_PATH%\usr\*;%ITI_HOME%\lib\*;%ITI_HOME%\*

    @REM SET CMD_EXCE=java -cp %CLS_PATH% com.chorke.boot.BootstrapMainApplication
    SET CMD_EXCE=java -classpath %CLS_PATH% com.chorke.boot.BootstrapMainApplication
    %CMD_EXCE%