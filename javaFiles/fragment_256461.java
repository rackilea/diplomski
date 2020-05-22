import java.util.*;
import java.util.function.*; 

public class CombiningMaps {

    private static Map<String, ServerInfo> map1 = new HashMap<>();
    private static Map<String, ServerInfo> map2 = new HashMap<>();

    private static BiFunction<String, ServerInfo, ServerInfo> combineWithMap2 = 
        (k, v) -> {
                    if (map2.get(k) != null) {
                        ServerInfo v2 = map2.get(k);
                        // combine values of map1 and map2
                        v.setHw2(v2.getHw2());
                    }
                    return v;
                };

    public static void main(String [] args) {

        // Add some test data to map 1
        map1.put("serv1", new ServerInfo("0A", "a1", "",""));
        map1.put("serv2", new ServerInfo("0B", "b1", "",""));
        map1.put("serv3", new ServerInfo("0C", "c1", "",""));
        System.out.println(map1);

        // Add some data to map 2
        map2.put("serv1", new ServerInfo("0A", "", "a2",""));
        map2.put("serv2", new ServerInfo("0B", "", "b2",""));
        map2.put("serv3", new ServerInfo("0C", "", "c2",""));
        System.out.println(map2);

        // Update map1 with map 2's info
        map1.forEach((k,v) -> map1.computeIfPresent(k, combineWithMap2));
        System.out.println(map1);
    }
}

class ServerInfo {
    private String ipAddr;
    private String hw1; // hw stands for hardware related info
    private String hw2;
    private String hw3;
    public ServerInfo(String ipAddr, String hw1, String hw2, String hw3) {
        this.ipAddr = ipAddr;
        this.hw1 = hw1;
        this.hw2 = hw2;
        this.hw3 = hw3;
    }
    public String getIpAddr() {
        return ipAddr;
    }
    public String getHw1() {
        return hw1;
    }
    public void setHw1(String s) {
        hw1 = s;
    }
    public String getHw2() {
        return hw2;
    }
    public void setHw2(String s) {
        hw2 = s;
    }
    public String getHw3() {
        return hw3;
    }
    public void setHw3(String s) {
        hw3 = s;
    }
    public String toString() {
        return ipAddr + ":" + hw1 + "-" + hw2 + "-" +  hw3;
    }
}