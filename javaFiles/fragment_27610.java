int totalDays = 548;

int years = (int)(totalDays / 360);
int months = (int((totalDays % 360) / 30);
int days = (int)((totalDays % 360) % 30);

System.out.println("years: " + years + "; months: " + months + "; days: " + days);

// Result: years: 1; months: 6; days: 8