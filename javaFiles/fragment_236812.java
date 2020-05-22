SortedSet<Highscore> highscores =
  new TreeSet<>(Comparator.comparingInt(highscore -> highscore.score));
highscores.add(new Highscore("user1", 10));
highscores.add(new Highscore("user2", 0));
highscores.add(new Highscore("user3", -15));
highscores.add(new Highscore("user4", 30));
highscores.add(new Highscore("user5", 5));