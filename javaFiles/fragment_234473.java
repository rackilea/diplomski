import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] d1 = {"iphone6","16000"};
        String[] d2 = {"iphone7","17000"};
        String[] d3 = {"iphone8","10000"};
        ArrayList<String[]> data1=new ArrayList<>();
        data1.add(d1);
        data1.add(d2);
        data1.add(d3);
        String[] d = getMinLaptopPrice(data1);
        System.out.print(d[0] + ", " + d[1]);
    }

    public static String[] getMinLaptopPrice(ArrayList<String[]> data) {
        int value_min = Integer.parseInt(data.get(0)[1]);
        String key_min = "";
        for(int i = 1; i < data.size(); i++) {
            int value = Integer.parseInt(data.get(i)[1]);
            if (value < value_min) {
                value_min = value;
                key_min = data.get(i)[0];
            }
        }
        String[] d = {key_min, String.valueOf(value_min)};
        return d;
    }
}