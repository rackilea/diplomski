class ClientVersionB {
public void showData() {
    DataObject dataObject = makeRequest(params);
    //Check whether data recieved is of version B after veryfying header                                         boolean status=validate(dataObject);
    if (status) {
        doIO(dataObject);
    }
}