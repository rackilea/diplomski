String.format("INSERT INTO SCANDATA (%s,%s) VALUES ('%s', '%s')",
       TaskContract.Columns.SCAN_RESULT,
       TaskContract.Columns.SCAN_RESULT_FORMAT,
       contents,
       format
);