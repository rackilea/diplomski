import org.ini4j.Ini;
import org.ini4j.Profile.Section;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) throws Exception {
        Ini ini = new Ini(new FileReader("test.ini"));
        System.out.println("Number of sections: "+ini.size()+"\n");
        for (String sectionName: ini.keySet()) {
            System.out.println("["+sectionName+"]");
            Section section = ini.get(sectionName);
            for (String optionKey: section.keySet()) {
                System.out.println("\t"+optionKey+"="+section.get(optionKey));
            }
        }
    }
}