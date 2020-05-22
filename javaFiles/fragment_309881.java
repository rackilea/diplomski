public boolean requestPickup(Passenger passenger, Class<?> vehicleClass){
            Object obj=Class.forName(vehicleClass.getName()).newInstance();

            if(obj instanceof Taxi){

                     //do taxi login
           }else if(obj instanceof Shuttle ){

                    //do shuttle logic
           }


    }