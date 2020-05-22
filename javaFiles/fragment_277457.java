ZoneOffset baseOffset = dateTimeWithBaseOffset.getOffset();
    ZoneOffset additionalOffset = dateTimeWithOffsetFromBase.getOffset();
    ZoneOffset correctedOffset = ZoneOffset.ofTotalSeconds(baseOffset.getTotalSeconds()
            + additionalOffset.getTotalSeconds());

    OffsetDateTime correctedDateTime = dateTimeWithOffsetFromBase.toOffsetDateTime()
            .withOffsetSameLocal(correctedOffset);
    System.out.println(correctedDateTime);