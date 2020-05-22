import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Example {
private static Map<String, List<String>> datacenterHostsMapping = new LinkedHashMap<String, List<String>>();

public static void main(String[] args) {

    datacenterHostsMapping.put("phx", Arrays.asList("h0","h1","h2"));
    datacenterHostsMapping.put("slc", Arrays.asList("h1","h0","h2"));
    datacenterHostsMapping.put("lvs", Arrays.asList("h2","h0","h1"));

    //Execute 5 times to print  data center and host information
    for(int i=1;i <=5;i++)
    {
        System.out.printf("Loop - %d \n", i);
        int index = 0;
        String[] randomHosts = generateRandomHosts(datacenterHostsMapping.get("phx"));
        for(String key :datacenterHostsMapping.keySet())
        {
            System.out.printf("%s - %s \n", key, randomHosts[index++] );
        }
        System.out.println();
    }
}

   private static String[] generateRandomHosts(List<String> hostsList) {
    Collections.shuffle(hostsList);
    String[] randomHosts = new String[hostsList.size()];
    hostsList.toArray(randomHosts);
    return randomHosts;
}
}