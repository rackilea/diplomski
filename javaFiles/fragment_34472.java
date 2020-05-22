import java.util.*;

class VirusData {
}

public class Test {

    public static void main(String[] args) {

        List<VirusData> list = new ArrayList<VirusData>() {{
            add(new VirusData());
            add(new VirusData());
            add(new VirusData());
        }};

        Iterator<VirusData> iterator = list.iterator();

        iterator.next();

        list.remove(0);
        VirusData s = iterator.next();
    }
}