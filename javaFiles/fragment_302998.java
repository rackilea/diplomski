MyDate Date = new MyDate(dayofmonth, month, year);

    Day myDay = Day.Sunday;

    int q = Date.getDay();
    int m = Date.getMonth();
    int K = (Date.getYear()%100);
    int J = (Date.getYear()/100);