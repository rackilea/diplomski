int shipsSet = 0;
do
{
    int pos = rnd.nextInt(sea.length);
    if(sea[pos] == '.'){  //pos available
        sea[pos] = 's';
        shipsSet++;
    }
}while(shipsSet < 2);