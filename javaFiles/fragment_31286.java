interface BInterface{ /*...*/ }

@Service
class B1 extends BInterface{/*...*/}

@Service
class B2 extends BInterface{/*...*/}

@Service
class B3 extends BInterface{/*...*/}

@Service
class BProvider {
  @Autowired
  private B1 b1;
  @Autowired
  private B2 b2;
  @Autowired
  private B2 b2;
  public BInterface get(String k) {
    switch(k){
      case "b1": return b1;
      case "b2": return b2;
      case "b3": return b3;
      default: return b1;
    }
  }
}

BClient {
  @Autowired
  private BProvider provider;
  public void doSomething(){
    BInterface b = provider.get(/* one of the three */);
    // use b ...
  }
}