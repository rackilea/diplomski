Event.Reminders reminders = new Event.Reminders();
reminders.setUseDefault(false);
List<EventReminder> listEventReminder = new ArrayList<EventReminder>();
listEventReminder.add(reminder);
reminders.setOverrides(listEventReminder);
event.setReminders(reminders);

System.out.println("Is null? = " + event.getReminders());