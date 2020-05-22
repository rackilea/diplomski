import java.util.Scanner;

public class InterPro {

    private int to = 0;
    private int from = 0;

    static String rooms[] = new String[12];
    private String room = null;
    private String delim = ", ";

    String room_allot(int from, int to) {

        for (int i = from - 1; i <= to - 1; i++) {

            if (rooms[i] == null) {

                rooms[i] = new String("Res");

                if (room == null)
                    room = "room" + (i + 1);
                else
                    room += delim + "room" + (i + 1);
            }
        }

        return room;
    }

    public static void main(String[] args) {

        try {
            Scanner s = new Scanner(System.in);

            InterPro ip = new InterPro();

            System.out.println("Enter the day from(between 1 to 12):\n");
            ip.setFrom(s.nextInt());
            System.out.println("Enter the day to(between 1 to 12):\n");
            ip.setTo(s.nextInt());

            String roomAlloted = ip.room_allot(ip.getFrom(), ip.getTo());

            if (roomAlloted == null)
                System.out
                        .println("Requested rooms are reserved. Enter other choice");
            else
                System.out.println("rooms alloted:" + roomAlloted);

            if (!ip.checkRoomAvailability()) {

                System.out.println("No rooms available!!!"
                        + " Program terminating... ");

                System.exit(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        main(null);
    }

    boolean checkRoomAvailability() {
        for (String string : rooms)
            if (string == null)
                return true;

        return false;
    }

    private int getTo() {
        return this.to;
    }

    private int getFrom() {
        return this.from;
    }

    private void setTo(int to) {
        this.to = to;
    }

    private void setFrom(int from) {
        this.from = from;
    }
}