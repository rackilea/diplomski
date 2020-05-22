public class Purchases{
    @SerializedName("buyers") protected ArrayList<PlayerRank> buyers;

    ...
}

public class PlayerRank{
    @SerializedName("IGN") protected String ign;
    @SerializedName("ProductID") protected int productId;

    ...
}