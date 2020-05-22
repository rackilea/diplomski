public class Gambler {
    public static void main(String[] args){
       double successes = 0;
       double bets = 0;
       for (int i = 0; i <1000;i++){
           double stake = 100;
           bets = 0; // initialize outside of for loop
           while(stake>0 && stake <200){
               bets++;
               if (Math.random()<0.5) stake ++;
               else stake --;
           }
           if (stake==200) successes++;

           System.out.println("stake = "+ stake + " bets made = " + bets);
       }    
       System.out.println("average successes = " + successes/1000);
       System.out.println("average bets = " + bets/1000);
    }
}