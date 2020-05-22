class Pots {
    List<Pot> Pot;
  }

  class Pot {
    protected String potType;
    protected List<Seed> Seed;
  }

  class HarvestBasket {
    protected String harvestBasketID;
    protected String harvestBasketName;
    protected int chance;
    protected List<HarvestContent> harvestContent;
  }

  class HarvestContent {
    protected String harvestItem;
    protected int min;
    protected int max;
  }

  class Seed {
    protected String seedType;
    protected List<HarvestBasket> HarvestBasket;
  }