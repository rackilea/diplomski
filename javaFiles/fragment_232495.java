import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MapReduceBenchmarkLauncher {

    private static List<Long> times = new ArrayList<Long>();

    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        pro.load(MapReduceBenchmarkLauncher.class.getResourceAsStream("/config.properties"));
        int benchRounds = Integer.parseInt(pro.getProperty("benchmark.rounds"));

        for(int i=0;i<benchRounds;i++) {
            JobMain jm = new JobMain();// app being tested

            long start = System.nanoTime();
            jm.run();
            long end = System.nanoTime();

            times.add(end-start);
        }
        writeTimekeepingToFile(times, "mapreduce_benchmark");
    }

    public static void writeTimekeepingToFile(List<Long> times, String benchfile) throws Exception {
        // arithmetic mean
        double am = 0;
        for(int i=0;i<times.size();i++) {
            am = am + times.get(i);
        }
        am = am / times.size();
        // varinaz calculation
        double v = 0;
        for(int i=0;i<times.size();i++) {
            v = v + (times.get(i)-am)*(times.get(i)-am); // no math lib, cause long
        }
        v = v / times.size();
        // calculating standard deviation
        double s = Math.sqrt(v);
        // output
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(benchfile), "utf-8"));
        for(int i=0;i<times.size();i++) {
            br.write("round "+(i+1)+": "+times.get(i)+" ns\n");
        }
        br.write("varianz: v="+v+"\n");
        br.write("standard deviation: t=("+am+" \u00B1 "+s+") ns" );
        br.close();
    }
}