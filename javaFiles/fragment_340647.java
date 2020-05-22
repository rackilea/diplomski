int[] years = new int[3];
    int i = 0;
    for (int year = 1999; year < 2045; year++) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            years[i++] = year;
            if (i > 2) {
                System.out.println(String.format("%d,%d,%d", years[0], years[1], years[2]));
                i = 0;
            }
        }
    }

2000,2004,2008
2012,2016,2020
2024,2028,2032
2036,2040,2044