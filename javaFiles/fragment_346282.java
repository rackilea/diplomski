Double latN =Math.asin(
            Math.sin(Math.toRadians(latitude)) * Math.cos(distance/radius) + 
            Math.cos(Math.toRadians(latitude)) * Math.sin(distance/radius) * Math.cos(Math.toRadians(0)));


    Double latS =Math.asin(
            Math.sin(Math.toRadians(latitude)) * Math.cos(distance/radius) + 
            Math.cos(Math.toRadians(latitude)) * Math.sin(distance/radius) * Math.cos(Math.toRadians(180)));


    Double longE = Math.toRadians(longitude) + 
                    Math.atan2(
                            Math.sin(Math.toRadians(90)) * Math.sin(distance/radius)* Math.cos(Math.toRadians(latitude)) 
            , Math.cos(Math.toRadians(distance/radius)) - Math.sin(Math.toRadians(latitude))* Math.sin(Math.toRadians(latN)) );

    Double longW = Math.toRadians(longitude) + 
    Math.atan2(
                    Math.sin(Math.toRadians(270)) * Math.sin(distance/radius)* Math.cos(Math.toRadians(latitude)) 
                , Math.cos(Math.toRadians(distance/radius)) - Math.sin(Math.toRadians(latitude))* Math.sin(Math.toRadians(latN)) );

    System.out.println("Latutude N "+Math.toDegrees(latN) +" Latitide S "+Math.toDegrees(latS) +">>> Longitude E "+Math.toDegrees(longE) +" Longitude W "+Math.toDegrees(longW));