String csvFile = "data1.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
     ArrayList <Hotel> hotel = new ArrayList();
    BufferedReader br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            Hotel hotelob = new Hotel();
            // use comma as separator
            String[] hotelproperties = line.split(cvsSplitBy);
            //setting properties to hotelobject
            hotelob.id = hotelproperties[0];  
            hotelob.name =hotelproperties[1];
            hotelob.star =hotelproperties[2];
            hotelob.rooms =hotelproperties[3];
            //adding the object to arraylist 
            hotel.add(hotelob);  
        }