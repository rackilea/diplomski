@RenderMapping(params={"action=addAppointment"}) // render phase
public String showAddAppointmentsForm(Model model) {
    //return new ModelAndView("add_appointment");
    System.out.println("TEST");
    return "add_appointment";
}