private void processData(LogData logObj, LogType type) {
    AuditLog audObj = new AuditLog();
    audObj.setImportId(logObj.id);
    audObj.setLogMessage(logObj.description);
    audObj.setEntryDateTimestampJoda(logObj.getStartDateTime());
    audObj.setExitDateTimestampJoda(logObj.getExitDateTime());
    insertAuditLogs(audObj);
}