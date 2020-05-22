interface ITest<T extends IResult> {
  List<T> getResult();
}

class ATest implements ITest<AResult> {
  // look, overridden!
  List<AResult> getResult();
}

class BTest implements ITest<BResult> {
  // overridden again!
  List<BResult> getResult();
}