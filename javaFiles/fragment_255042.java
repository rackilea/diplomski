static LinkedHashMap complete = new LinkedHashMap();
    static Set Pagecounter = new TreeSet();
    static Set Usecounter = new TreeSet();
    static Set Testcounter = new TreeSet();
    static String totalNumber;

   /**
     * @param logData
     * @return
     */
    public static LinkedHashMap logIteration(LinkedHashMap logData) {
        Set keys = logData.keySet();
        Iterator itr = keys.iterator();
        boolean available = false;
        boolean tcAvailable = false;
        while (itr.hasNext()) {
            String key = (String) itr.next();
            String value = (String) logData.get(key);
            if (value.equalsIgnoreCase("Fail")) {
                tcAvailable = true;
            }
            String[] listArray = key.split("~");
            if (complete.size() > 0) {
                Set moduleName = complete.keySet();
                Iterator itr1 = moduleName.iterator();
                while (itr1.hasNext()) {
                    String key1 = (String) itr1.next();
                    if (listArray[0].equals(key1)) {
                        available = true;
                        break;
                    } else {
                        available = false;
                    }
                }
            } else {
                available = true;
            }
            if (available) {
                processControl(listArray, tcAvailable);
            } else {
                clearSet();
                if (tcAvailable) {
                    tcAvailable = false;
                }
                processControl(listArray, tcAvailable);
                available = false;
            }
        }
        return complete;
    }

    /**
     * @param listArray
     * @param tcstatus
     */
    private static void processControl(String[] listArray, boolean tcstatus){
        Pagecounter.add(listArray[1].trim());
        Usecounter.add(listArray[2].trim());
        Testcounter.add(listArray[3].trim());
        if (tcstatus) {
            totalNumber = Pagecounter.size() + "~" + Usecounter.size() + "~" + Testcounter.size() + "~Fail";
        } else {
            totalNumber = Pagecounter.size() + "~" + Usecounter.size() + "~" + Testcounter.size() + "~Pass";
        }
        complete.put(listArray[0], totalNumber);
    }

    /**
     * 
     */
    private static void clearSet(){
        Pagecounter.clear();
        Usecounter.clear();
        Testcounter.clear();
    }