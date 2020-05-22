package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        String[] serviceList = " , 15 , 18 , 19, ".split("[\\s,]+");
        for (String serviceAuth : serviceList) {
            if ("".equals(serviceAuth))
                continue;
            Long temp = Long.parseLong(serviceAuth.toString());
            System.out.println(temp);
        }
    }
}