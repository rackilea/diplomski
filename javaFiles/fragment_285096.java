public enum Element {
  HYDROGEN,
  HELIUM,
  SODIUM,
  //.....
  URANIUM,
  WILD_CARD;

  public boolean consideredEqual(Object other) {
    if (other == null || ! (other instanceof Element)) return false;

    Element e = (Element) other;
    if (this.equals(Element.WILD_CARD) || e.equals(Element.WILD_CARD)) return true;
    return equals(other);
  }
}