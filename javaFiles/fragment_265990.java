HandlerCollection handlers = new HandlerCollection();
ContextHandlerCollection contexts = new ContextHandlerCollection();
// your context specific handlers are added to "contexts" here
server.setHandler(handlers);

NCSARequestLog requestLog = new NCSARequestLog();
requestLog.setFilename("/path/to/my/logs/yyyy_mm_dd.request.log");
requestLog.setFilenameDateFormat("yyyy_MM_dd");
requestLog.setRetainDays(90);
requestLog.setAppend(true);
requestLog.setExtended(true);
requestLog.setLogCookies(false);
requestLog.setLogTimeZone("GMT");
RequestLogHandler requestLogHandler = new RequestLogHandler();
requestLogHandler.setRequestLog(requestLog);
handlers.addHandler(requestLogHandler);