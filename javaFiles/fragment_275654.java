int dateComparison = o2[0].compareTo(o1[0]);
if (dateComparison != 0) return dateComparison;

int stringComparison = o2[1].compareTo(o1[1]);
if (stringComparison != 0) return stringComparison;

int secondDateComparison = o2[2].compareTo(o1[2]);
return dateComparison;