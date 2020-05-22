private int season;
private int episode;
private String name;
private ZonedDateTime airDate;
private Context context;

public Countdown(String name, int episode,int season,ZonedDateTime airDate, Context context){
        this.airDate = airDate;
        this.name = name;
        this.episode = episode;
        this.season = season;
        this.context = context;
    }