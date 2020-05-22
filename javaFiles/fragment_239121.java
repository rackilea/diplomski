if(!validateRecords(Records.get(i)[j].toString())) {
    Logging.info("Records could not be parsed " + Records.get(i)[j]);
    Records.get(i)[j] = "CouldNotBeParsed";
} else {
    Logging.info(Records.get(i)[j] + " has been sanitized");
}