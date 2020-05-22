double R = 6371.0; // km
        double dLat = (lat2-lat1)*Math.PI/180.0;
        double dLon = (lon2-lon1)*Math.PI/180.0;
        lat1 = lat1*Math.PI/180.0;
        lat2 = lat2*Math.PI/180.0;

        double a = Math.sin(dLat/2.0) * Math.sin(dLat/2.0) +
                Math.sin(dLon/2.0) * Math.sin(dLon/2.0) * Math.cos(lat1) * Math.cos(lat2); 
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
        double d = R * c;       

        return d*1000;