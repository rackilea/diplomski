List<String> online_players = new List<String>();
//fill list code here

List<String players_in_config = new List<String>();
//fill list code here

List<String> output = new List<String>();

for(String s : online_players){
    for(String a : players_in_config){
        if(s.equals(a)){
            output.add(s);
        break;
        }
    }
}

//and now output contains the names of the players that online and have a bed in the config