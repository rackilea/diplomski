Exchanger<Carta> exchanger = new Exchanger<>();
Intercambiador i1 = new Intercambiador(exchanger);
Intercambiador i2 = new Intercambiador(exchanger);

new Thread(()->i1.intercambiar1()).start();
new Thread(()->i2.intercambiar2()).start();