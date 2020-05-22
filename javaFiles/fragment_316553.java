@Controller
    @RequestMapping("/cars")
    public clas CarController
    {
        @RequestMapping(method = RequestMethod.get)
        public final @ResponseBody String carsHandler(
            final WebRequest webRequest)
        {
            String parameter = webRequest.getParameter("blammy");

            if (parameter == null)
            {
                return getAll();
            }
            else
            {
                return findCar(webRequest);
            }
        }
    }