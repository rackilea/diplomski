// February is the only month that needs special handling
if (month == 2) {
    // Do your special handling of leap year etc...
} else if (month >= 1 && month <= 12) {
    // All other valid months go here. Since Java arrays are zero-based,
    // we subtract 1 from the month number
    days = dayCount[month-1];
    monthout = monthName[month-1];
} else {
    // Put handling of invalid month here
}
out = "There are " + days + " days in " + monthout;