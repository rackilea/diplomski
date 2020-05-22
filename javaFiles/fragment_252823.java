Set<Highscore> highscores = new HashSet<>();

highscores.add(new Highscore("user 1", 25));
highscores.add(new Highscore("user 2", 10));
highscores.add(new Highscore("user 3", 55));
highscores.add(new Highscore("user 1", 25));
highscores.add(new Highscore("user 2", 5));
highscores.add(new Highscore("user 3", 30));

System.out.println(highscores.size());