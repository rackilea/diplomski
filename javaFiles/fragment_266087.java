import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecentsList implements IO {

    private List<Recent> recents;

    public RecentsList() {
        recents = new ArrayList<Recent>();
    }

    public void addRecent(Recent recent) {
        recents.add(recent);
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(recents.size());
        for (Recent r : recents) {
            r.write(out);
        }
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        int size = in.readInt();
        recents = new ArrayList<Recent>(size);
        for (int i = 0; i < size; i++) {
            Recent r = new Recent();
            r.read(in);
            recents.add(r);
        }
    }

    public static void main(String[] args) throws IOException {
        RecentsList test = new RecentsList();

        // build test data
        for (int i = 0; i < 100; i++) {
            String iString = Integer.toString(i);
            Recent r = new Recent(iString, iString, new Date(), i);
            test.addRecent(r);
        }

        // write
        File out = new File("/home/till/recents.bin");
        DataOutputStream dataOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(out)));
        test.write(dataOut);
        dataOut.close();

        // read
        RecentsList read = new RecentsList();
        DataInputStream dataIn = new DataInputStream(new BufferedInputStream(new FileInputStream(out)));
        read.read(dataIn);
        dataIn.close();

        System.out.println("read now contains same data as test if everything went ok");
    }

}