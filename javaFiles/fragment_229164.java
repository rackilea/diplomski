for (Player p : users) {
        System.out.println(p.getNick() + "'s turn!"); 
        System.out.println("Your score is: " + p.getScoreTotal() + "!");
        takeTurn(p);              
          if (p.getScoreTotal() >= 100) {
            System.out.println(p.getNick() + "wins! Congratulations"); 
            return;
          }
    }