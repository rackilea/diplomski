int year = delta / 365;
int rest = delta % 365;
int month = rest / 30;
rest = rest % 30;
int weeks = rest / 7;
int days = rest % 7;