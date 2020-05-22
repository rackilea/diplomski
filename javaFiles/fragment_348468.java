Date getTodayStart( Date inDate){
Calendar cal = Calendar.getInstance()
    cal.set(inDate[Calendar.YEAR], inDate[Calendar.MONTH], inDate[Calendar.DATE], 0, 0, 0)
    Date todayStart = cal.getTime()

    return todayStart
}

Date getTodayEnd(Date inDate){
Calendar cal = Calendar.getInstance()
    cal.set(inDate[Calendar.YEAR], inDate[Calendar.MONTH], inDate[Calendar.DATE], 0, 0, -1)
    Date todayEnd = cal.getTime() + 1

    return todayEnd
}