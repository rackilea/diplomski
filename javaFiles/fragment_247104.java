int getUserApartmentNumber(User user) {
    if(user != null) {
       Address address = user.getAddress();
       if(address != null) {
          Building building = address.getBuilding();
          if (building != null) {
             Apartment apartment = building.getApartment();
             if(apartment != null) {
                return apartment.getNumber();
             }
          }
        }   
     }
     return -1;
 }