Trainer tr1 = new Trainer("George","White","England",5665);
Athlete ath1 = new Athlete("Mairy","Willians","France",1,'f',"21/3/1988",68,172,"France");
ath1.setTrainer(tr1); // set the other side of the link
list.add(ath1);
...
tr1.setAthletes(list);