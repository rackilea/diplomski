JsonFactory jsonFactory = new JacksonFactory();
// notificationString is parsed form httpRequest's inputstream which is send from Mirror API
Notification notification = jsonFactory.fromString(notificationString, Notification.class);
if (notification.getUserActions().contains(new UserAction().setType("CUSTOM").setPayload("dealMenu")) {
    // User selected CUSTOM menu item on your glassware        
}