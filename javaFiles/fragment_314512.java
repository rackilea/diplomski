interface Behaves { public Output behaviour(Input i); }
class Behaviour1 implements Behaves {
  public Output behaviour(Input i){ /* your implementation here*/ }
}
class FunctionBasedBehaviour implements Behaves {
  private final Function<Input,Output> f;
  public FunctionBasedBehaviour (Function<Input,Output> f) {this.f=f;}
  public Output behaviour(Input i){  return f(i); }
}