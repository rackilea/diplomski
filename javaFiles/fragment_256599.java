public void displayTeam(Pokemon[] team){
    System.out.println("\n|-NUM-|----POKEMON NAME----|--DEX--|--TYPE 1--|--TYPE 2--|--HP--|-SPEED--|-STATUS-|");
    for(int i=0; i<team.length;i++){
        String fnt="   OK   ";
        if(team[i].checkFaint()){fnt=" FAINT! ";}
        System.out.println("|  "+i+"  |"+stringSpacer(null,20)+"|  "+team[i].getDex()+"  |"+stringSpacer(null,10)+"|"+stringSpacer(null,10)
                +"|"+stringSpacer(null +"",6)+"|"+stringSpacer(null +"",8)+"|"+fnt+"|");
    }
}