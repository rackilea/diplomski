@RequestMapping("/activeSlots")
@ResponseBody
public String getTime(@RequestParam("date") String date){

    AvailableTimeSlot ts = new AvailableTimeSlot();
    List<String> bookedTime = ts.getInfo(date);
    LinkedHashMap<String,String> availTimeSlots = ts.availTime(bookedTime);

    Gson gson = new GsonBuilder().create();
    String json = gson.toJson(availTimeSlots);

    return json;
}