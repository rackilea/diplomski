//return no value (void)
public static void replacePlayer(int jersey, int newJersey, int newRating){

        for(i=0; i<numArray;++i){
            if(numJersey[i]==jersey){
                numJersey[i] = newJersey; //numJersey newRating are class variables so they will be updated
                numRating[i] = newRating;
            }
        }
 }