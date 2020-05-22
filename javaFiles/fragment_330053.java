final List<Beer> beers = new ArrayList<>();
beers.add(new Beer("tre", "nome2"));
beers.add(new Beer("due", "snome2"));
beers.add(new Beer("uno", "nome1"));
beers.add(new Beer("uno", "nome5"));
beers.add(new Beer("uno", "nome4"));
beers.add(new Beer("uno", "nome2"));
beers.add(new Beer("due", "nome1"));

Collections.sort(beers, Beer::compareTo);