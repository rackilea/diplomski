import com.jacob.com.Variant;
import com.jacob.com.Dispatch;

public class JunoReader {

  String pyClsid = "{PYTHON-COM-CLSID-HERE}"; // This is where your python COM clsid goes
  String opClsid = "{TARGET-COM-CLSID-HERE}"; // This is where your ultimate target clsid goes 

  public JunoReader() {
    _pyClsid = "clsid:" + pyClsid
    // This finds the COM object location:
    Dispatch oOphirLink = new Dispatch(_pyClsid);  
  }

  public String HandShake() {
    String _talkBack = "is connected.";
    Variant _handShake = Dispatch.call(oOphirLink,"Hello",_talkBack); // I am trying to look for the Juno...
    return (_handShake.toString());
  }

  public String ConnectOphir() {
    Variant _connectOphir = Dispatch.call(oOphirLink,"ConnectOphir", opClsid); // Connect to the target COM object
    return (_connectOphir.toString());
  }

  public String ScanUSB() {
    Variant _serialNumberList = Dispatch.call(oOphirLink,"ScanUSB"); // This scans the USB ports for devices
    return (_serialNumberList.toString());
  }
}