//find the least danger:
int leastDanger = northDanger;
if(southDanger < leastDanger) leastDanger = southDanger;
if(eastDanger  < leastDanger) leastDanger = eastDanger;
if(westDanger  < leastDanger) leastDanger = westDanger;
// Go the first direction equal to least danger 
if      (northDanger == leastDanger) { moveNorth
}else if(southDanger == leastDanger) { moveSouth
}else if(eastDanger  == leastDanger) { moveEast
}else if(westDanger  == leastDanger) { moveWest
}