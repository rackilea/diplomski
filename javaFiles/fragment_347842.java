@Controller
public class MainController {
    //Get CommandInterpreter object
    private CommandInterpreter ci = new CommandInterpreter();
    private List <Vehicle> vehicles;

    MainController() throws Exception {
        //Set up list of vehicles from JSON
        vehicles = ci.parseJsonVehicles();
    }

    @RequestMapping("/vehicles-by-price")
    public ModelAndView getVehiclesByPrice() {
        vehicles = ci.getVehiclesByPrice(vehicles);

        ModelAndView mv = new ModelAndView();
        mv.add("vehicles", vehicles);
        mv.setViewName("vehiclesByPrice");
        return mv;
    }
}