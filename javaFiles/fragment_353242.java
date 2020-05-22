//Check if user is registered
var onDeviceReady=function() {
    //See if the push user exists already
    //You can send any unique user id and password.
    AppMobi.notification.checkPushUser(AppMobi.device.uuid, AppMobi.device.uuid);
};
document.addEventListener("appMobi.device.ready",onDeviceReady,false);


//if user is not registered, register them
var isUserAdded = false;
var notificationsRegistered=function(event) {
    if(event.success === false) {
        if (!isUserAdded) {
            isUserAdded= true;
            AppMobi.notification.addPushUser(AppMobi.device.uuid, 
                                              AppMobi.device.uuid, 
                                             'no@email.com');
            return;
        }
        AppMobi.notification.alert("Notifications Failed: " + event.message,
                                   "My Message","OK");
        return;
    }
    var msg = event.message || 'success';
   AppMobi.notification.alert("Notifications Enabled: " + msg,
                              "My Message","OK");
};
document.addEventListener("appMobi.notification.push.enable",
                           notificationsRegistered,false);

//when push message event is found get notification
var receivedPush = function(){
    var myNotifications=AppMobi.notification.getNotificationList();
    //It may contain more than one message, so iterate over them
    var len=myNotifications.length;
    if(len > 0) {
        for(i=0; i < len; i++) {
            msgObj=AppMobi.notification.getNotificationData(myNotifications[i]);
            try{
                if(typeof msgObj == "object" && msgObj.id == myNotifications[i]){
                    AppMobi.notification.alert(msgObj.msg + "\n" + msgObj.data 
                     + "\n" + msgObj.userkey,"pushMobi Message","OK");
                    //Always delete messages after they are shown 
                    AppMobi.notification.deletePushNotifications(msgObj.id);
                    return;
                }
                AppMobi.notification.alert("Invalid Message Object: " + i,
                                           "My Message","OK");
            }catch(e){
                AppMobi.notification.alert("Caught Exception For: " + msgObj.id,
                                           "My Message","OK");
                AppMobi.notification.deletePushNotifications(msgObj.id);
            }
        }
    }
};
document.addEventListener("appMobi.notification.push.receive", receivedPush, false);


//send a push notification from your website
AppMobi.notification.sendPushNotification(myAppMobiUserID,"new website blog posted!",{});
document.addEventListener("appMobi.notification.push.send",updateNotificationEvent,false);
var updateNotificationEvent=function(event)
{
    if(event.success==false)
{
    alert("error: " + event.message)
}
    else
    {
        alert("success");
    }
}