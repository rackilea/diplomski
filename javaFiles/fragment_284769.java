Pattern p1 = Pattern.compile("target=\"FmRight\">\\d+");
Pattern p2 = Pattern.compile("<TD Nowrap >[^<]*</TD>");
Matcher m = p1.matcher(text);
int count = 0;
int regionStart= 0;                          // <-----
for (int i = 0; i < 3; i++) {
    if(m.find()) {
        regionStart = m.end();               // <-----
        System.out.println(m.group().split(">")[1]);
    }
    m.usePattern(p2);
    m.region(regionStart, m.regionEnd());    // <-----
    count=0;
    for(int j=0;j<2;j++){
        if(m.find()) {
            regionStart = m.end();           // <-----
            System.out.println(m.group().split(">")[1].split("<")[0]);
        }
    }
    m.usePattern(p1);
    m.region(regionStart, m.regionEnd());    // <-----
    count=1;
}