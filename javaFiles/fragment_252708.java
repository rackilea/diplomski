fetch all companies

int totalCompanies = companies.size();
int progress = 0;

for all companies {
    progress++;
    if company equals("Car Center") {  
        locationList.add(new LocationData(lati, longi, nameFirst1 + " " + nameLast1,otherinfo));

        // you do not have to use publishProgress
        // but if you do I though giving a percentage of progress instead of data1 makes sense
        publishProgress((progress/totalCompanies)*100); 
    }
}