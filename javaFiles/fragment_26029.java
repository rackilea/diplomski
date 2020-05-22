// has no android or j2se specific code
public class common {
    public void someCommonfunction() {...someOsSpecificcode(); ...}
    protected abstract void someOsSpecificcode();
}

// has android specific code
public class commonAndroid extends common {
    protected void someOsSpecificcode() { /* android specific implementation */ }
}

// has j2se specific code
public class commonJ2se extends common {
    protected void someOsSpecificcode() { /* j2se specific implementation */ }
}