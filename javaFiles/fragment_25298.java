long triggerTime = calendar.getTimeInMillis();
if (triggerTime  <= System.currentTimeMillis() + 3000) 
{
    // 3 Second distance

   calendar.add(Calendar.DATE, 1);  // Add 1 day --> Trigger 1 day later from now
}