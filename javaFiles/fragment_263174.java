String line;
while((line = reader.readLine()) != null) {
    try {
        return parseRecord(line);
    }catch (ParseException pex){
        logger.warn("Record ignored due to parse error: " + pex);
    }
}
return null;