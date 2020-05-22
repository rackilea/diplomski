reception add=new Reception();
do {
    ...
    add.setNumerodehotel(x);
    add.setResidente1(name);
} while (...)

public abstract class Hotel {
    ArrayList<Integer> numerodehotel = new ArrayList<Integer>();
    ArrayList<String> residente1 = new ArrayList<String>();

    public Hotel(){
    }

    public void setNumerodehotel(int number){
       this.hotelroomnumber.add(number);
    }

    public void setResidente1(String resident){
       this.resident1.add(resident);
    }
}