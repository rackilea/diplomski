int[] scores={10,50,20,60};
        String[] players={"player1","player2","player3","player4"};
        Hashtable<String, String> playerdetails=new Hashtable<String, String>();
        ArrayList scoreslist=(ArrayList) Arrays.asList(scores);
        for(int i=0;i<scores.length;i++)
        {
            playerdetails.put(String.valueOf(scores[i]), players[i]);
        }
        Collections.sort(scoreslist);
        for(int i=0;i<scoreslist.size();i++)
        {
            show.setText(scoreslist.get(i)+"    "+playerdetails.get(scoreslist.get(i)));
        }