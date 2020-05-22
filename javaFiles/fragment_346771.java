public class MyConnectionManager<E extends Operation>{

private E _wf;

public MyConnectionManager(E wf) {
    // TODO Auto-generated constructor stub
    _wf= wf;
}

public Boolean IsConnected() {
    // TODO Auto-generated method stub
     return _wf.IsConnected();
}


public Boolean ConnectionOpen() {
    // TODO Auto-generated method stub
    return  _wf.ConnectionOpen();
}


public Boolean ConnectionClose() {
    // TODO Auto-generated method stub
    return _wf.ConnectionClose();
}