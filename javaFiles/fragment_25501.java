int indexI = 0;
int indexJ = 0;     

for (i = 0; i < 4; i++){
        for (j = 0; j < 4; j++){
            System.out.println("Map of the land owned:");
            System.out.println(map[i][j]);
            if (map[i][j] != 1 || map[i][j] != 0){
                b = false;
                indexI = i;
                indexJ = j; 
            }

        }
 }       

if (b == false){
System.out.println("Map does not have the correct format");
System.out.println("--> A value of " + map[indexI][indexJ] + " was found at " + indexI + "," + indexJ);

}
else{
System.out.println("Map of the land owned: ");
System.out.println("The map is valid");
return;
}