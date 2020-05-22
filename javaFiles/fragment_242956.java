@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest req) throws Exception {
        logger.info("Welcome home! The client locale is {}.", locale);
        String currentString = null; //here
        String csvFilename1 = "C:/temp/csv/curdata.csv";
        CSVReader reader1 = new CSVReader(new FileReader(csvFilename1));     

        while ((CurnextLine = reader1.readNext()) != null) {
            currentString += CurnextLine[0] + "\t" + CurnextLine[1] + "\t" + CurnextLine[2] + "\t" + CurnextLine[3] + "\t" + "|"; //appending each data each time the while loop loops
            curdate = CurnextLine[0];
            curtype = CurnextLine[1];
            cursys = CurnextLine[2];
            curdes = CurnextLine[3];
        }
        model.addAttribute("currentString", currentString); //This is the long appended string which is to be split in the jsp page by the delimiter '|'

        model.addAttribute("curdate", curdate);
        model.addAttribute("curtype", curtype);
        model.addAttribute("cursys", cursys);
        model.addAttribute("curdes", curdes);

        String csvFilename2 = "C:/temp/csv/futdata.csv";
        CSVReader reader2 = new CSVReader(new FileReader(csvFilename2));

        while ((FutnextLine = reader2.readNext()) != null) {

            futdate = FutnextLine[0];
            futtype = FutnextLine[1];
            futsys = FutnextLine[2];
            futdes = FutnextLine[3];
        }

        model.addAttribute("futdate", futdate);
        model.addAttribute("futtype", futtype);
        model.addAttribute("futsys", futsys);
        model.addAttribute("futdes", futdes);    

        return "home";
    }