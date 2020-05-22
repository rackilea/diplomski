public class StatusImpl {
    public static StatusType parseStringToEnum( String value ){
        return StatusType.valueOf( value );
    }
    public static String printEnumToString( StatusType impl ){
        return impl.toString();
    }
}