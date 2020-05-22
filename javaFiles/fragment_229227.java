foreach (Day d in DateRange) {
    foreach (UserDateRange u in UserDateRanges) {
        //check if the date range (u) covers the day in question (d)
        if (d > u.Start && d < u.End) {
              //we're done checking this day because it's covered by at least one range
              covered = true;
        }
    }

    if (!covered) return false;
}

return true; //because if we got this far, every day is "covered"