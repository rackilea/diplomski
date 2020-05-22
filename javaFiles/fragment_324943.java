public JSONObject encodeJsonObject(Reservation reservation){
    JSONObject obj=new JSONObject();
    obj.put("id",String.valueOf(reservation.getId()));  
    obj.put("product","/api/reservation/product/"+reservation.getProduct().getId()+"/");      
    obj.put("reserv_date_start",new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+00:00'").format(reservation.getReserv_date_start()));
    obj.put("reserv_finish",new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+00:00'").format(reservation.getReserv_finish()));        
    obj.put("resource_uri", "/api/reservation/reservation/"+reservation.getId()+"/");
    obj.put("user", "/api/reservation/auth/user/1/"); //not dynamic yet
    obj.put("penalty",reservation.isPenalty());
    return obj;
}