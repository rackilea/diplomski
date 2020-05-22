@RequestMapping(value = "/allGridView", method = RequestMethod.GET)
public @ResponseBody
Object[] showLineChart(Map<String, Object> map, HttpServletRequest request,
        HttpServletResponse response) {
    List<MapTable> gsmList = contactService.fin();
    Object[] gsmArray = new Object[gsmList.size()];
    int i = 0;
    for (Iterator iterator = gsmList.iterator(); iterator.hasNext();) {
        MapTable gsmTable = (MapTable) iterator.next();
        Object[] obj = new Object[2];
        obj[0] = gsmTable.getSRDate();
        obj[1] = gsmTable.getNumberOfSR();
        gsmArray[i] = obj;
        i++;
    }

    // =====================================================================================
    List<SMSTable> smsList = contactService.sms();
    Object[] smsArray = new Object[smsList.size()];
    i=0;
    for (Iterator iterator = smsList.iterator(); iterator.hasNext();) {
        SMSTable smsTable = (SMSTable) iterator.next();
        Object[] obj = new Object[2];
        obj[0] = smsTable.getSRDate();
        obj[1] = smsTable.getNumberOfSR();
        smsArray[i] = obj;
        i++;
    }
    // =====================================================================================
    List<GPRSTable> gprsList = contactService.gprs();
    Object[] gprsArray = new Object[gprsList.size()];
    i=0;
    for (Iterator iterator = gprsList.iterator(); iterator.hasNext();) {
        GPRSTable gprsTable = (GPRSTable) iterator.next();
        Object[] obj = new Object[2];
        obj[0] = gprsTable.getSRDate();
        obj[1] = gprsTable.getNumberOfSR();
        gprsArray[i] = obj;
        i++;
    }

    Object[] p=new Object[3];
    p[0]=gsmArray;
    p[1]=smsArray;
    p[2]=gprsArray;
    return p;
}