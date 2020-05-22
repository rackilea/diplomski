class Man {
  Wife wife;
}
class Wife {
  Man man;
}
Man joe = new Man();
Wife ann = new Wife();
joe.wife = ann;
ann.man = joe;