request.set("security", ticker);
request.set("eventType", EventType.TRADE);
request.set("interval", 1);
request.set("gapFillInitialBar", true);
request.set("startDateTime", startDate);
request.set("endDateTime", startDate);