int finalMax = workers[0].getMax(); //Sets max as first worker's max

for (int x = 1; x < workers.length; x++) {
     if(finalMax < workers[x].getMax())//checks whether finalMax is less than worker's max at x'th position and if yes assigns it to finalMax         
        finalMax = workers[x].getMax();        
}

System.out.println("Final Max " + finalMax );