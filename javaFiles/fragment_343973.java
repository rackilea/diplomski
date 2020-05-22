import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coord {
    public int a, b, c, d, e, f;

    private static class CoordsThread extends Thread {
        private int start;
        private int end;
        private List<Coord> coords;
        private PrintWriter out;

        public CoordsThread(int start, int end, List<Coord> list, PrintWriter out) {
            this.start = start;
            this.end = end;
            this.coords = list;
            this.out = out;

            // last block can be shorter
            if( this.end > this.coords.size() ) this.end = this.coords.size();
        }

        public void run() {
            System.out.println("started thread "+getName()+" for ["+start+";"+end+")");
            for (int i = start; i < end; i++) {
                for (int j = 0; j < coords.size(); j++ ) {
                    Coord c1 = coords.get(i);
                    Coord c2 = coords.get(j);
                    double foo = ((c1.a - c2.a) * (c1.a - c2.a)) * 1;
                    double goo = ((c1.b - c2.b) * (c1.b - c2.b)) * 1;
                    double hoo = ((c1.c - c2.c) * (c1.c - c2.c)) * 2;
                    double joo = ((c1.d - c2.d) * (c1.d - c2.d)) * 2;
                    double koo = ((c1.e - c2.e) * (c1.e - c2.e)) * 4;
                    double loo = ((c1.f - c2.f) * (c1.f - c2.f)) * 4;
                    double zoo = Math.sqrt(foo + goo + hoo + joo + koo + loo);

                    synchronized (out) {
                        out.println(i*coords.size()+j + "; " + i + " " + j + " " + zoo);
                    }
                }
            }
            System.out.println("completed thread "+getName());
        }
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("2.txt")));
        Scanner sc = new Scanner(new File("1.txt"));
        List<Coord> coords = new ArrayList<Coord>();

        // for each line in the file
        while (sc.hasNextLine()) {
            String[] numstrs = sc.nextLine().split("\\s+");

            Coord c = new Coord();

            c.a = Integer.parseInt(numstrs[1]);
            c.b = Integer.parseInt(numstrs[2]);
            c.c = Integer.parseInt(numstrs[3]);
            c.d = Integer.parseInt(numstrs[4]);
            c.e = Integer.parseInt(numstrs[5]);
            c.f = Integer.parseInt(numstrs[6]);

            coords.add(c);
        }

        System.out.println("total lines read: "+coords.size());

        int threadsCount = 4;
        List<Thread> ths = new ArrayList<Thread>();

        int blockSize = coords.size()/threadsCount+1;
        for( int i=0; i<threadsCount; ++i  ) {
            CoordsThread ct = new CoordsThread(i*blockSize, (i+1)*blockSize, coords, out);
            ct.setName("Block"+i);
            ths.add(ct);
        }

        for (Thread th : ths) {
            th.start();
        }

        for (Thread th : ths) {
            th.join();
        }

        out.flush();
        out.close();
    }
}