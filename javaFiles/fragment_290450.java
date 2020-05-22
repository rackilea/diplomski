public class Reservations {

static final int  DAY_SUN = 0, DAY_MON = 1, DAY_TUE = 2, DAY_WED = 3, DAY_THU = 4, DAY_FRI = 5, DAY_SAT = 6;
static final int ROOM_1 = 0, ROOM_2 = 1, ROOM_3 = 2, ROOM_4 = 3, ROOM_5 = 4;
private static HashMap<Integer[], String[]> hMap = new HashMap<Integer[], String[]>();


static String [] getStringForValue(Integer[] i){
    return hMap.get(i);
}

static TreeSet<String> getOrderedOutputStrings(){
    TreeSet<String> set = new TreeSet<String>();
    for(Entry<Integer[],String[]> e : hMap.entrySet()){
        int day_int = Reservations.getDay(e.getKey());
        int room_int = Reservations.getRoom(e.getKey());
        int time = Reservations.getTime(e.getValue());
        String name = Reservations.getGuestName(e.getValue());
        String day = Reservations.dayToString(day_int);
        String room = Reservations.roomToString(room_int);
        if(time > 0)
        set.add("DAY: " + "(" + day_int + ")" + day + " (" + room_int + ")"+ "ROOM: " + room + " :: " + name + " @ " + time);
    }
    return set;
}



static void setupMap() {
    for (int day = 0; day < 7; day++) {
        for (int room = 0; room < 5; room++) {
            addGuest(day, room, (int)(Math.random()*1000), "Bob TestCase");
        }
    }
}

static void addGuest(int day, int room, int time, String name) {
    Integer[] ref = new Integer[2];
    ref[0] = day;
    ref[1] = room;
    String[] s = new String[2];
    s[0] = Integer.toString(time);
    s[1] = name;
    hMap.put(ref, s);
}

static String[] lookupRoom(int day, int room) {
    Integer[] i = new Integer[2];
    i[0] = day;
    i[1] = room;
    return hMap.get(i);
}

static int getDay(Integer[] i){
    return i[0];
}

static int getRoom(Integer[] i ){
    return i[1];
}

static int getTime(String[] s) {
    return Integer.parseInt(s[0]);
}

public static String getGuestName(String[] s) {
    return s[1];
}

public static String dayToString(int i){
    switch(i){
        case 0:
            return "SUNDAY";
        case 1:
            return "MONDAY";
        case 2:
            return "TUESDAY";
        case 3:
            return "WEDNESDAY";
        case 4:
            return "THURSDAY";
        case 5:
            return "FRIDAY";
        case 6:
            return "SATURDAY";
        default:
            return null;
    }
}

public static String roomToString(int i){
    switch(i){
        case 0:
            return "ROOM ONE";
        case 1:
            return "ROOM TWO";
        case 2:
            return "ROOM THREE";
        case 3:
            return "ROOM FOUR";
        case 4:
            return "ROOM FIVE";
        default:
            return null;
    }
}