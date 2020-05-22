private boolean function isFutureTimestamp(){
        String gwtTimestampFormat = convertToGwtTimeStampFormat(timestampFormat); 
        // timestampFormat = YYYY-MM-DD HH:mm:ss.S AM/PM z
        // gwtTimestampFormat = yyyy.MM.dd HH:mm:ss.S a z

        DateTimeFormat df = DateTimeFormat.getFormat(gwtTimestampFormat); 

        String newlyUpdatedTimestampValue = convertToGwtTimeStampFormat(timestampValue);
        Date updatedDateTime = df.parse(newlyUpdatedTimestampValue); 

        String currentTimestamp = convertToGwtTimeStampFormat(currentTimestampValue);
        Date currentDateTime = df.parse(currentTimestamp);

        boolean isFutureTimestamp  = updatedDateTime.after(currentDateTime);
        return isFutureTimestamp;
}

  private String convertToGwtTimeStampFormat(String gwtTimestampFormat) {

        if (gwtTimestampFormat != null && gwtTimestampFormat.length() > 20) { // "2012-12-23 23:12:32.2".length= 21
            gwtTimestampFormat = gwtTimestampFormat.replace("-", ".");
            gwtTimestampFormat = gwtTimestampFormat.replace("YYYY", "yyyy");
            gwtTimestampFormat = gwtTimestampFormat.replace("DD", "dd");
            gwtTimestampFormat = gwtTimestampFormat.replace("AM/PM", "a");
            return gwtTimestampFormat;
        }
        else {
            return "";
        }
    }