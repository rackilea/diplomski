void addToQueue(Object obj) {

     queue.add(obj)
     boolean raisAlarm = false;

     while (queue.size() > 1000) {
         queue.remove(); 
         raisAlarm  = true;
      }


      if (raisAlarm) {
            // raiseAlarm mtheod will return boolean value to indicate 
            // the result of raising alarm
            boolean m_alarmRaised = alarmConnection.raiseAlarm();
            if (m_alarmRaised) {
              alarmConnection.clear();
            }
     }
}