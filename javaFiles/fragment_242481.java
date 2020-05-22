private static int reminderID = 1;

public synchronized static String generateUniqueID() {
    String uniqueId = "Reminder-" + reminderID;
    reminderID++;
    return uniqueId;
}