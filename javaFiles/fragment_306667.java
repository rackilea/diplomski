int k = (i * listDest.size()) + j;
    int dur = Integer.parseInt(listDur.get(k));
    if (dur != 0) { // skip instances where orig and dest are the same
        DurationBetween durationBetween = new DurationBetween(dur, orig, dest);
        listDurBtwn.add(durationBetween);
    }