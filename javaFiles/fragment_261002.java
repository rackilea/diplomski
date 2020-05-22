// suggestion: make the marker immutable, then you can store and reuse them instead of recreating them every time
Marker marker1 = new MyMarkerImpl(
    "REPORT", // marker name
    "me@company.com, joe@company.com", // smtpTo
    "alertGroup"); // discriminatingValue
logger.warn(marker1, "SNAFU");
Marker marker2 = new MyMarkerImpl(
    "REPORT", "boss@company.com, ceo@company.com", "phbGroup");
logger.info(marker2, "Everything is fine");
// here we have same smtpTo as above but different discriminatingValues, so this will be sent in another email/report
Marker marker3 = new MyMarkerImpl(
    "REPORT", "me@company.com, joe@company.com", "bugFixingGroup");
logger.error(marker3, "Why things gone bad", exception);