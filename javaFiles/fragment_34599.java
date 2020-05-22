...
@RequestMapping(value = "/searchChair", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
        public @ResponseBody
        List<Chair> findChair(@RequestBody Reserv reserv) {
            List<String> chairNumber = reserv.getChairNumebers();
            int busId = reserv.getBusId();
            System.out.println("ChairNUMBER!!!!!!!!!" + chairNumber);
            List<Chair> chair = chairService.chairsFind(chairNumber, busId);
            System.out.println("HERE" + chair);
            return chair;
        }
    ...
      private class Reserv{
            int busId;
            List<String> chairNumber;
            //getter setters
        }