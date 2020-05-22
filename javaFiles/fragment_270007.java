@RequestMapping(value="/create", method=RequestMethod.GET)
public String createAppointmentPost(Model model, @ModelAttribute("city") City 
city, 
        @ModelAttribute("agency") Agency agency){

    Appointment appointment=new Appointment();
    model.addAttribute("appointment", appointment);
    model.addAttribute("dateString", "");
    model.addAttribute("cities", cityService.findAll());
    return "appointment";
}       

@RequestMapping(value = "/agencies", method = RequestMethod.GET)
public @ResponseBody
List<Agency> findAllAgencies(
        @RequestParam(value = "cityId", required = true) Long cityId) {
    City city = cityService.findCity(cityId);
    return agencyService.listAllAgencies(city);
}