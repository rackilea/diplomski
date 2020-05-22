public final class PropertyManager {

  /**
   * The PropertyManager instance, example usage:
   *   PropertyManager.INSTANCE.buyProperty(property, buyer);
   * NB: Good candidate for dependency injection instead if you are doing this.
   */
  public static final PropertyManager INSTANCE = new PropertyManager();

  private static final Map<Property, Player> propertyListing = new HashMap<Property, Player>();

  /**
   * Buy a property from the banker, banker or property manager could maintain
   * Collection of available properties
   */
  public void buyProperty(Player buyer, Property property) {
    if (propertyListing.containsKey(property)) {
      throw new IllegalStateException("Unable to buy unless owner sells it");
    }
    propertyListing.put(property, buyer);
  }

  /**
   * Broker a transaction between two players for the sale of a property
   */
  public void sellProperty(Player seller, Player buyer, Property property) {
    if (!propertyListing.containsKey(property)) {
      throw new IllegalStateException("Unable to sell Property which is not owned");
    }
    Player owner = propertyListing.get(property);
    if (!owner.equals(seller)) {
      throw new IllegalStateException("Unable to sell property seller doesn't own");
    }
    // TODO : Deduct/transfer monies (ensure sufficient value in buyer account etc)
    propertyListing.put(property, buyer); 
  }

  /**
   * Retrieve a List of all of the Player's properties
   */
  public List<Property> getProperties(Player owner) {
    // TODO Either iterate through the propertyListing or use a second Map for player to List<Property>, NB: they should be guarded with a shared lock if you do this (threading).
  }

  /**
   * Retrieve the owner of a Property or null if it is unowned
   */
  @Nullable // javax annotation indiciates can be null
  public Player getOwner(Property property) {
    return propertyListing.get(property);
  }

  /**
   * Hide the constructor as the only property manager should be INSTANCE
   */
  private PropertyManager() {
    // Prevent further instantiation
  }
}