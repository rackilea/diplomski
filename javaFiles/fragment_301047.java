String[] city = getCities ();  // assuming this code is done
int[] temp = getTemparatures ();
int max = Integer.MIN_VALUE;
int index = -1;

for(int i = 0; i < temp.length; i ++){
    if(max < temp[i]){
        max = temp[i];
        index = i;
    }
}

System.out.println ("The city with the highest average temperature is " + city[index] + 
" with an average temperature of " + temp[index]);