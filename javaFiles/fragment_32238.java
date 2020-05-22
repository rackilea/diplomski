Log log = iterator.next();

if (log.getPhonenumber() == phonenumber  && log.getType() == type && log.getDate() == date)
{
    updateLog(newLog, log .getId());
    ...