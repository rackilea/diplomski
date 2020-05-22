Calendar rangeStart = Calendar.getInstance();
int dayB, monB, yearB;

dayB = this.readGetParameterAsInteger("startDay");
monB = this.readGetParameterAsInteger("startMonth");
yearB = this.readGetParameterAsInteger("startYear");

rangeStart.set(yearB, monB-1, dayB, 0, 0, 0);