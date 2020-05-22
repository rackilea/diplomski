public class StackOverflow {

    private static final String numberRegex = "[0-9]*[a-zA-Z]?"; // 123a 123
    private static final String compassRegex = "N|E|S|W|NORTH|EAST|SOUTH|WEST|NORD|EST|SUD|OUEST";
    private static final String typeRegex = "STREET|ST|DRIVE|DR|AVENUE|AVE|AV|ROAD|RD|LOOP|LP|COURT|CT|CIRCLE|LANE|LN|BOULEVARD|BLVD|CRESCENT|CR";
    private static final Pattern addrLong = Pattern.compile("(" + numberRegex + ")\\s(.*)\\s(" + typeRegex + ")\\s?(" + compassRegex + ")?");

    public static void main(final String[] args) {
        final String address = "12 CLARE ST E";
        final Hashtable<String, String> result = splitAddress(address);
        System.out.println(result.get("number"));
    }

    private static Hashtable<String, String> splitAddress(final String address) {
        final Hashtable<String, String> result = new Hashtable<String, String>();

        final Matcher m = addrLong.matcher(address);
        if (m.matches()) {
            result.put("number", m.group(1));
        }
        return result;
    }
}