for (int i = 0; i < Records.size(); i++) {
    if(!validateRecords(Records.get(i)[0].toString())) {
        Logging.info("Records could not be parsed " + Records.get(i)[0]);
        Records.get(i)[0] = "CouldNotBeParsed";
    } else {
        Logging.info(Records.get(i)[0] + " has been sanitized");
    }
}