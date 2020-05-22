enum Colour{

        RED(1), BLUE(2);

        public int value;

        Colour(int valueArg){ 
            value = valueArg; 
        }

        /*public setValue(int a){
            value = a;
        }

        public getValue(){
            return value;
        }*/

    }

    public class Test{
        static Colour colour = Colour.BLUE;
        public static void main(String[] args){
            colour.value = 3;
            //colour.setValue(3);
       }
  }