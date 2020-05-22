public class BLEUtils {

    public static final long BT_UUID_LOWER_BITS = 0x800000805F9B34FBl;
    public static final long BT_UUID_UPPER_BITS = 0x1000l;
    public static final long BT_CCCD_SHORT_UUID = 0x2902l;
    public static final UUID BT_CCCD_UUID = get16BitBTUUID(BT_CCCD_SHORT_UUID);

    public static UUID get16BitBTUUID(long uuid) {
        return new UUID(BT_UUID_UPPER_BITS + (uuid << 32), BT_UUID_LOWER_BITS);
    }
}