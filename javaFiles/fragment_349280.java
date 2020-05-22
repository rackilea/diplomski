import java.util.*;

public class CarProduct{

    String color;
    String modelname;
    String price;
    public CarProduct(String c, String m, String p){
        color = c;
        modelname = m;
        price = p;
    }

    @Override
    public String toString()
    {
        return "Model: " + modelname + " Colour:" + color + " Price:" + price ;
    }
}

class HashMapApplication{

    public static void main(String []ar){

        List<CarProduct> arraylist1 = new ArrayList<CarProduct>();
        List<CarProduct> arraylist2 = new ArrayList<CarProduct>();
        List<CarProduct> arraylist3 = new ArrayList<CarProduct>();

        Map<String,List<CarProduct>> hashmap = new HashMap<String, List<CarProduct>>();

        CarProduct Tata = new CarProduct("black","12 Lakhs","Aria");
        arraylist1.add(Tata);
        hashmap.put("Tata",arraylist1);

        CarProduct WolksWagen = new CarProduct("off white","10 Lakhs","Passat");
        arraylist2.add(WolksWagen);
        hashmap.put("WolksWagen",arraylist2);

        CarProduct Mahindra = new CarProduct("white","15 Lakhs","XUV");
        arraylist3.add(Mahindra);
        hashmap.put("Mahindra",arraylist3);

        for (Map.Entry<String, List<CarProduct>> entry : hashmap.entrySet()) {
            System.out.print(entry.getKey()+" | ");
            for(CarProduct property : entry.getValue()){
                System.out.print(property+" ");
            }
            System.out.println();
        }

    }

}