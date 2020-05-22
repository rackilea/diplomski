if ((incr == 0 || incr == -1) && val != ALL_SPEC_INT) {
        if (val != -1) {
            set.add(Integer.valueOf(val));
        } else {
            set.add(NO_SPEC);
        }

        return;
    }