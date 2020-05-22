class Liger {

private Tiger tiger = new Tiger();
private Lion lion = new Lion();

void swim() { tiger.swim(); }

void socialize() { lion.socialize() ; }

Tail getTail() { return lion.getTail(); }

Skin getSkin() { return tiger.getSkin(); }

}