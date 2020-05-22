public class LoopPractice {

    public static void main(String[] args) {
        for(int counter = 0; counter<7; counter++){

            for(int times=0;times<=counter;times++){

                if(counter%2==0){

                    System.out.print("/");

                }else{

                    System.out.print("\\");

                }
            }

            System.out.println();           
        }
    }

}