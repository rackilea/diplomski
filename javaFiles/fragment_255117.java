if (isSet[DAY_OF_WEEK]) { //yup we set this
        int first = getFirstDayOfMonth(year, month);

        // 3: YEAR + MONTH + DAY_OF_WEEK_IN_MONTH + DAY_OF_WEEK
        if (isSet[DAY_OF_WEEK_IN_MONTH]) { //we didn't set this, but it's been set!
            if (fields[DAY_OF_WEEK_IN_MONTH] < 0) { 
                month++;
                first = getFirstDayOfMonth(year, month);
                day = 1 + 7 * (fields[DAY_OF_WEEK_IN_MONTH]);
            } else
                day = 1 + 7 * (fields[DAY_OF_WEEK_IN_MONTH] - 1); 
                 // 15 = 1 + 7 * (3 - 1)

            int offs = fields[DAY_OF_WEEK] - first;
            if (offs < 0)
                offs += 7;
            day += offs;
        }
    }