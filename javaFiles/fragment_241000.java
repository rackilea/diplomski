class CompanyFilter {

    @SerializedName("ids")
    private List<Integer> mIds;

    @SerializedName("hexdigest")
    private String mDigest;

    @SerializedName("total")
    private String mTotalCount;

    @SerializedName("page")
    private int mPage;

    @SerializedName("sort")
    private String mSort;

    @SerializedName("new")
    private boolean mNew;

    public List<Integer> getIds() {
        return mIds;
    }

    public String getDigest() {
        return mDigest;
    }

    public String getTotalCount() {
        return mTotalCount;
    }

    public int getpage() {
        return mPage;
    }

    private String buildRequest() {
        String out = "total=" + mTotalCount + "&";
        out += "sort=" + mSort + "&";
        out += "page=" + mPage + "&";
        out += "new=" + mNew + "&";
        for (int i = 0; i < mIds.size(); i++) {
            out += "ids[]=" + mIds.get(i) + "&";
        }
        out += "hexdigest=" + mDigest + "&";
        return out;
    }
}

private static class Company {

    private String mLink;
    private String mName;
    private String mDescription;

    public Company(String name, String link, String description) {
        mLink = link;
        mName = name;
        mDescription = description;
    }

    public String getLink() {
        return mLink;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
} 

private static class HtmlContainer {

    @SerializedName("html")
    private String mHtml;

    public String getHtml() {
        return mHtml;
    }
}