Map<String, CalibrationHistoryEntity> unique = new HashMap<String, CalibrationHistoryEntity>();

    for (CalibrationHistoryEntity k : allCalibrationList) {
        CalibrationHistoryEntity temp = unique.getOrDefault(k.Name, null);

        if (temp == null || temp.time.before(k.time))
            unique.put(k.Name, k);
    }