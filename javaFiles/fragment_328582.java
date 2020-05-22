@Controller
    public class DataCollector {

        @RequestMapping(value = "/clientdatacollector", method = RequestMethod.POST)
        public @ResponseBody
        void abc(Writer writer, @RequestParam("gpsdata") String gpsJSON) {



            try {
                // here is your jsonstring ;)
                writer.write(gpsJSON.toString());

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }