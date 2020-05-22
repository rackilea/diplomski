for(int i = 0; i < game.getRolls().length; i ++)
{
    String sep = "|";
    if(i%2 == 0){
       System.out.print(sep);
    }
    else{
       System.out.print(",");
    }
    System.out.print(game.getRolls()[i]);
}