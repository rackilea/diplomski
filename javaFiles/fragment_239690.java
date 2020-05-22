long diffYear = diff / year;
long diffMonth = (diff - (diffYear * year)) / month;
//long diffWeeks= ((diff % month)) / weeks;
long diffWeeks = (diff - (diffYear * year + diffMonth * month)) / weeks;
//long diffDays = ((diff % weeks)) / days;
long diffDays = (diff - (diffYear * year + diffMonth * month + diffWeeks*weeks)) / days;//((diff % weeks)) / days;