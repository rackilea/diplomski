ArrayList eventListPerDayPerBadge = new ArrayList();
ArrayList eventListPerDay = new ArrayList();
HashMap eventMapByDay = new HashMap();
HashMap eventMapByDayByBadge = new HashMap();

int lastDay = 0;
int eventDay = 1;
String lastBadge = "0";
String currentBadge = "currentBadge";
Event event = null;

Iterator eventList = employeeEvents.iterator();
while (eventList.hasNext()) {

    event = (Event) eventList.next();
    eventDay = DateUtil.toCalendar(event.getEvent_s_date()).get(Calendar.DATE);

    currentBadge = event.getBadge();

    if (eventDay == lastDay) {
        eventListPerDay.add(event);
        if (currentBadge.equals(lastBadge)) {
            eventListPerDayPerBadge.add(event);
        }
        else {
            HashMap tempMap = new HashMap();
            if (eventMapByDayByBadge.get(lastBadge) != null) {
                tempMap = (HashMap) eventMapByDayByBadge.get(lastBadge);
            }
            tempMap.put(new Long(eventDay), eventListPerDayPerBadge);
            eventMapByDayByBadge.put(lastBadge, tempMap);
            eventListPerDayPerBadge = new ArrayList();
            eventListPerDayPerBadge.add(event);
        }
        eventMapByDay.put(new Long(eventDay), eventListPerDay);
    }
    else {
        if (!"0".equals(lastBadge)) {
            HashMap tempMap = new HashMap();

            if (eventMapByDayByBadge.get(lastBadge) != null) {
                tempMap = (HashMap) eventMapByDayByBadge.get(lastBadge);
            }
            tempMap.put(new Long(lastDay), eventListPerDayPerBadge);
            eventMapByDayByBadge.put(lastBadge, tempMap);
            eventMapByDay.put(new Long(lastDay), eventListPerDay);
        }

        eventListPerDayPerBadge = new ArrayList();
        eventListPerDayPerBadge.add(event);

        eventListPerDay = new ArrayList();
        eventListPerDay.add (event);

    }

    lastDay = eventDay;
    lastBadge = currentBadge;
}


// Get the last record into the maps    
HashMap tempMap = new HashMap();
if (eventMapByDayByBadge.get(lastBadge) != null) {
    tempMap = (HashMap) eventMapByDayByBadge.get(lastBadge);
}
tempMap.put(new Long(eventDay), eventListPerDayPerBadge);
eventMapByDayByBadge.put(lastBadge, tempMap);
eventMapByDay.put(new Long(eventDay), eventListPerDay);

request.setAttribute("eventMapByDayByBadge", eventMapByDayByBadge);
request.setAttribute("eventMapByDay", eventMapByDay);