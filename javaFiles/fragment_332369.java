function deleteEvent(eventId) {

 var baseUrl = "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/{eventId}?sendNotifications=true";
 var calendarId = CalendarApp.getDefaultCalendar().getId();
 eventId = eventId.substr(0, eventId.indexOf("@"));

 var url = baseUrl.replace("{calendarId}", calendarId).replace("{eventId}", eventId);

  var options = {

    "method": "DELETE",
    "headers": {"Authorization":"Bearer " + ScriptApp.getOAuthToken()},
    "muteHttpExceptions": true

  };

  var res = UrlFetchApp.fetch(url, options).getContentText();  
  Logger.log(res);    


}