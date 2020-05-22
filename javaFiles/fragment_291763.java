String sql = "select dealer_id,car_servicing,car_servicing,cost,features from 
dealer_car,carservicing where dealer_car.car_servicing=carservicing.car_servicing
and dealer_id=:dealer_id";
String[] types = new String[]{"int"}; //or maybe string?
String[] vals = new String[]{dealerId};
ResultSet rs = DBConnection.fireSelect(sql, types, vals);