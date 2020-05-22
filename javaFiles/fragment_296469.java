//These are the offset you add to the current position
int [] movx ={-1, -1, -1, 0, 0, 1, 1, 1};
int [] movy ={-1, 0, 1, -1, 1, -1, 0, 1};

//this variable will hold if we found or not the string in the puzzle
boolean found = false;

//check all directions
for (int i = 0; i < 8; i++){
    //found the string, change the flag 'found' and break
    if(check(row, col, word, puzzle, movx[i], movy[i])){
        found = true;
        break;
    }
}

//string not found
if (!found){
    System.out.println("String not found");
}