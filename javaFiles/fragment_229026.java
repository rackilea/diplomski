static List<Wine> parseLine(String line, List<Wine> wineInfo) {
    String year = null;
    String area = null;
    String brand = null;
    String type = null;
    String variety = null;
    String bin = null;
    String numbottles = null;
    String drinkyear = null;
    String cost = null;
    Wine wine = new Wine(year, area, brand, type, variety, bin,
            numbottles, drinkyear, cost);
    int length = line.length();
    int j = 0;
    char yr[] = new char[3];

    for (int i = 0; i < 3; i++) {
        yr[j] = line.charAt(i);
        year = new String(yr);
        j = j + 1;
    }
    char temp[] = new char[7];
    j = 0;
    for (int i = 3; i < 10; i++) {
        temp[j] = line.charAt(i);
        area = new String(temp);
        j = j + 1;
    }
    char temp1[] = new char[12];
    j = 0;
    for (int i = 10; i < 22; i++) {
        temp1[j] = line.charAt(i);
        brand = new String(temp1);
        j = j + 1;
    }
    char temp3[] = new char[2];
    j = 0;
    for (int i = 22; i < 24; i++) {
        temp3[j] = line.charAt(i);
        type = new String(temp3);
        j = j + 1;
    }
    char temp2[] = new char[21];
    j = 0;
    for (int i = 24; i < 45; i++) {
        temp2[j] = line.charAt(i);
        variety = new String(temp2);
        j = j + 1;
    }
    char tmp[] = new char[6];
    j = 0;
    for (int i = 45; i < 51; i++) {
        tmp[j] = line.charAt(i);
        bin = new String(tmp);
        j = j + 1;
    }
    char temp4[] = new char[3];
    j = 0;
    for (int i = 51; i < 54; i++) {
        temp4[j] = line.charAt(i);
        numbottles = new String(temp4);
        j = j + 1;
    }
    char temp5[] = new char[4];
    j = 0;
    for (int i = 54; i < 58; i++) {
        temp5[j] = line.charAt(i);
        drinkyear = new String(temp5);
        j = j + 1;
    }
    char temp6[] = new char[7];
    j = 0;
    for (int i = 58; i < length; i++) {
        temp6[j] = line.charAt(i);
        cost = new String(temp6);
        j = j + 1;
    }

    wine.setYear(year);
    wine.setArea(area);
    wine.setBrand(brand);
    wine.setType(type);
    wine.setVariety(variety);
    wine.setBin(bin);
    wine.setNumbottles(numbottles);
    wine.setDrinkYear(drinkyear);
    wine.setCost(cost);

    wineInfo.add(new Wine(year, area, brand, type, variety, bin,
            numbottles, drinkyear, cost));

    return wineInfo;
}