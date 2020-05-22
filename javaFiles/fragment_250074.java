String sponsor;
String start;
String miles;
Document doc;

while(cursor.hasNext()){
    doc = cursor.next();
    sponsor = doc.get("sponsor").toString();
    start = doc.get("start").toString();
    miles = doc.get("miles").toString();

    // Process your values and go to the next record 
}