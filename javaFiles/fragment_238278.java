DateTime thisDateTime = new DateTime("2016-05-07T07:01:00.000Z");

        thisDateTime = thisDateTime.withZone(DateTimeZone.UTC);

        thisDateTime = thisDateTime.toLocalDateTime().toDateTime();

        DateTime mstTime = thisDateTime.withZone(DateTimeZone.forID("MST"));    

        int offset = mstTime.getZone().getOffset(new DateTime().getMillis());

        Timestamp mstTimeStamp = new Timestamp(mstTime.getMillis() + offset); // -25200000 == 7 hours

        ps.setTimestamp(i, mstTimeStamp); //2016-05-07 00:01:00