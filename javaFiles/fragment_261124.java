interface Item{
    int data=0;
    String text="";
public int getData();
public String getText();

}
public class Test12{
    public static void main(String[] args){
        Item item=new Item(){ public int data=2; public String text="an item";
            public int getData(){
                return data;
            }
            public String getText(){
                return text;
            }
            public boolean equals(Object object){
                if(object instanceof Item){
                    Item test=(Item)object; //tests on next line
                    System.out.println(test); System.out.println(String.format("data: %d; text: \"%s\"", test.getData(), test.getData())); //returns data and text fields of interface, after returning fields defined in anonymous class on toString call
                    System.out.println(test); //toString returns same
                    return data==test.getData() && text.equals(test.getText()); } return false;}
            public String toString(){return String.format("{data: %d; text: \"%s\"}", data, text);} };

        System.out.println(((Object)item).equals(item)); //returns false
    }
}