import java.util.*;
import java.lang.*;
import java.io.*;

public class TestMemberOuter1 {
    public static void main(String args[]) throws java.lang.Exception {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int max = 0;
        ArrayList<Integer> game = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            int t = in.nextInt();
            game.add(i, t);
        }

        int counter = 0;

        while(game.size()>0){
            for(int j = 0; j < game.size(); j++){

                if(max <= (int)game.get(j))
                {
                    max=j;
                }
                for(int i = 0; i < game.size(); i++){
                    counter = counter + (int)game.get(max);
                    if(max < game.size() )
                    {
                        game.remove(game.get(max));
                    }
                    if(max+1 <  game.size() )
                    {
                        game.remove(game.get(max+1));
                    }

                    if(max-1 > 0 )
                    {
                        game.remove(game.get(max-1));
                    }

                }
            }

        }
        System.out.print(counter);
        in.close();
    }
}