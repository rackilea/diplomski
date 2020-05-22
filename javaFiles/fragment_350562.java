import A.E;
class B {
    E eThing;     // works because A.E was imported
    A.E eThing2;  // always works provided A is known (in same package here)
    . . .
}