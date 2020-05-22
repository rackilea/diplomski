if (  reservationsList !=null && !reservationsList.isEmpty())
{


  System.out.println("reservationsList size: " + reservationsList.size());
 //String json =gson.toJson(reservationsList); 

response.getWriter().write(reservationsList.get(0).getPerson().getName()); } 
else {
    response.getWriter().write("record not found")

}