import java.io.IOException;
import java.util.Date;

public class Recent implements IO {

    private String name, number;
    private Date date;
    private int duration; // in milliseconds

    public Recent(String name, String number, Date date, int duration) {
        this.name = name;
        this.number = number;
        this.date = date;
        this.duration = duration;
    }

    public Recent() {
        this(null, null, null, 0);
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        byte[] nameData = name.getBytes("UTF-8");
        out.writeInt(nameData.length);
        out.write(nameData);

        byte[] numberData = number.getBytes("UTF-8");
        out.writeInt(numberData.length);
        out.write(numberData);

        out.writeLong(date.getTime());

        out.writeInt(duration);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        int nameDataLength = in.readInt();
        if (nameDataLength > 100000) throw new IllegalStateException("Name shouldn't be this long: " + nameDataLength);
        byte[] nameData = new byte[nameDataLength];
        in.readFully(nameData);
        name = new String(nameData, "UTF-8");

        int numberDataLength = in.readInt();
        if (numberDataLength > 100000) throw new IllegalStateException("Number shouldn't be this long: " + nameDataLength);
        byte[] numberData = new byte[numberDataLength];
        in.readFully(numberData);
        number = new String(numberData, "UTF-8");

        date = new Date(in.readLong());

        duration = in.readInt();
    }

}