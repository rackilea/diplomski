int days = totalSeconds / 86400;
totalSeconds -= days * 86400;
int hours = totalSeconds / 3600;
totalSeconds -= hours * 3600;
int minutes = totalSeconds / 60;
int seconds = totalSeconds % 60;