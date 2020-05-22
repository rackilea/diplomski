SimpleDateFormat dateFormatTZGeneral = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
    SimpleDateFormat dateFormatTZISO = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS XXX");
    SimpleDateFormat dateFormatWithoutTZ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


    String[][] zoneStrings = DateFormatSymbols.getInstance().getZoneStrings();

    Date date = null;

    String[] timeStampSplits = timestamp.split(" ");
    if(timeStampSplits.length>2) {

        String timezone = timeStampSplits[2];
        //First Case Asia/Calcutta
        if(Character.isAlphabetic(timezone.charAt(timezone.length()-1))) {

            for(String[] zoneString: zoneStrings) {
                if(zoneString[0].equalsIgnoreCase(timezone)) {
                    timeStampSplits[2] = zoneString[2];
                    break;
                }
            }

            timestamp = createString(timeStampSplits," ");
            date = getDate(timestamp, dateFormatTZGeneral);
        } else {
            //Second Case 8:00
            timeStampSplits[2] = formatTimeZone(timeStampSplits[2]);

            timestamp = createString(timeStampSplits," ");
            date = getDate(timestamp, dateFormatTZISO);
        }

    } else {
        // Third Case without timezone
        date = getDate(timestamp, dateFormatWithoutTZ);
    }

    System.out.println(date);

    TIMESTAMPTZ oraTimeStamp = new TIMESTAMPTZ(<connection object>,new java.sql.Timestamp(date.getTime());