@Service
class BProvider {
  @Autowired
  private Map<String,BInterface> bs;

  public BInterface get(String k) {
    return bs.get(k);
  }
}