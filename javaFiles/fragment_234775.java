...
EXCEPTION
  WHEN OTHERS THEN
    DECLARE
      job_state varchar2(4000);
      status ku$_Status;
    BEGIN
      DBMS_DATAPUMP.GET_STATUS(
        handle    => jobhandle,
        mask      => dbms_datapump.KU$_STATUS_JOB_ERROR,
        timeout   => null,
        job_state => job_state,
        status    => status);

    FOR I IN 1..status.error.COUNT LOOP
      DBMS_OUTPUT.PUT_LINE(status.error(I).errornumber || ': ' || status.error(I).logtext);
    END LOOP;
  END;

  RAISE;
END;
/