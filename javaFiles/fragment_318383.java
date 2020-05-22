public class TestModel {
@SerializedName("Meta Data")
@Expose
private MetaModel mMetaModel;

public MetaModel getMetaModel() {
    return mMetaModel;
}

public void setMetaModel(final MetaModel metaModel) {
    mMetaModel = metaModel;
}

public Map<String, TimeModel> getTimeModel() {
    return mTimeModel;
}

public void setTimeModel(final Map<String, TimeModel> timeModel) {
    mTimeModel = timeModel;
}

@SerializedName("Time Series (1min)")

@Expose
private Map<String,TimeModel> mTimeModel;

public static class MetaModel{

    @SerializedName("1. Information")
    @Expose
    private String _1Information;
    @SerializedName("2. Symbol")
    @Expose
    private String _2Symbol;
    @SerializedName("3. Last Refreshed")
    @Expose
    private String _3LastRefreshed;
    @SerializedName("4. Interval")
    @Expose
    private String _4Interval;
    @SerializedName("5. Output Size")
    @Expose
    private String _5OutputSize;
    @SerializedName("6. Time Zone")
    @Expose
    private String _6TimeZone;

    public String get_1Information() {
        return _1Information;
    }

    public void set_1Information(final String _1Information) {
        this._1Information = _1Information;
    }

    public String get_2Symbol() {
        return _2Symbol;
    }

    public void set_2Symbol(final String _2Symbol) {
        this._2Symbol = _2Symbol;
    }

    public String get_3LastRefreshed() {
        return _3LastRefreshed;
    }

    public void set_3LastRefreshed(final String _3LastRefreshed) {
        this._3LastRefreshed = _3LastRefreshed;
    }

    public String get_4Interval() {
        return _4Interval;
    }

    public void set_4Interval(final String _4Interval) {
        this._4Interval = _4Interval;
    }

    public String get_5OutputSize() {
        return _5OutputSize;
    }

    public void set_5OutputSize(final String _5OutputSize) {
        this._5OutputSize = _5OutputSize;
    }

    public String get_6TimeZone() {
        return _6TimeZone;
    }

    public void set_6TimeZone(final String _6TimeZone) {
        this._6TimeZone = _6TimeZone;
    }
}
public static class TimeModel{
    @SerializedName("1. open")
    @Expose
    private String _1Open;
    @SerializedName("2. high")
    @Expose
    private String _2High;
    @SerializedName("3. low")
    @Expose
    private String _3Low;
    @SerializedName("4. close")
    @Expose
    private String _4Close;
    @SerializedName("5. volume")
    @Expose
    private String _5Volume;

    public String get_1Open() {
        return _1Open;
    }

    public void set_1Open(final String _1Open) {
        this._1Open = _1Open;
    }

    public String get_2High() {
        return _2High;
    }

    public void set_2High(final String _2High) {
        this._2High = _2High;
    }

    public String get_3Low() {
        return _3Low;
    }

    public void set_3Low(final String _3Low) {
        this._3Low = _3Low;
    }

    public String get_4Close() {
        return _4Close;
    }

    public void set_4Close(final String _4Close) {
        this._4Close = _4Close;
    }

    public String get_5Volume() {
        return _5Volume;
    }

    public void set_5Volume(final String _5Volume) {
        this._5Volume = _5Volume;
    }
}