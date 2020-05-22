ConnectableFlux<String> x1 = Flux.just("x1").publish();
ConnectableFlux<String> x2 = Flux.just("x2").publish();

ConnectableFlux<String> y1 = Flux.<String>from(Flux.merge(x1, x2)).publish();
ConnectableFlux<String> y2 = Flux.<String>from(Flux.merge(x1, x2)).publish();
ConnectableFlux<String> y3 = Flux.<String>from(Flux.merge(x1, x2)).publish();

ConnectableFlux<String> z3 = Flux.<String>from(Flux.merge(y1, y2, y3)).publish();

x1.connect();
x2.connect();
y1.connect();
//...etc.