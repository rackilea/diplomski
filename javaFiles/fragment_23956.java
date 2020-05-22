if (listGridRecord.getAttribute("expirationDays") != null) {
    Date tmpDate = endDate.getValue();
    CalendarUtil.addDaysToDate(tmpDate, Integer.parseInt(listGridRecord.getAttribute("expirationDays")));
    listGridRecord.setAttribute("expirationDate", tmpDate);
} else {
    listGridRecord.setAttributeAsJavaObject("expirationDate", null);
}