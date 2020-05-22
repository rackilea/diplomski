@Override
public void sendRemoteRecord(String token, int channelId, int eventId, final ServiceCallback<RemoteRecordResponse> callback) {

    epgServicesApiManager.sendRemoteRecord(token, channelId, eventId)
            .observeOn(scheduler)
            .subscribe(new SuccessCallbackAction<RemoteRecordResponse>(callback), 
                       new ErrorCallbackAction(callback));
}

@Override
public void activateRemoteRecord(String token, String cardNumber, final ServiceCallback<RemoteRecordActivateResponse> callback) {

    epgServicesApiManager.activateRemoteRecord(token, cardNumber)
            .observeOn(scheduler)
            .subscribe(new SuccessCallbackAction<RemoteRecordActivateResponse>(callback),
                       new ErrorCallbackAction(callback));
}