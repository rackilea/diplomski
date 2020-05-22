String json = "{\"IdCustomer\":\"bb05ee35-0494-49e3-9e40-38d5dae10668\",\"Name\":\"VenditaAbiti2\",\"Domain\":\"Commerce2\"}";
        Gson g = new Gson();
        Community community = g.fromJson(json, Community.class);
        System.out.println("Community:" + community.toString());

    }

    class Community {
    @SerializedName("IdCustomer")
    private String idCustomer;

    @SerializedName("Name")
    private String name;

    @SerializedName("Domain")
    private String domain;

    @Override
    public String toString() {
        return "Community [idCustomer=" + idCustomer + ", name=" + name + ", domain=" + domain + "]";
    }

//getter setter