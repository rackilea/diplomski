public class ValidatorChain implements Iterable<Validator> {
  Collection<Validator> validators = ...;
  public Iterator<Validator> iterator() {
    return validators.iterator();
  }
}