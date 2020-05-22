@XmlRootElement("Settings")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Settings {
    private List<GameSetting> gameSetting;
    private ScoreSetting scoreSetting;
    @XmlElement
    public List<GameSetting> getGameSetting(){
        if( gameSetting == null ){
            gameSetting = new ArrayList<>();
        }
        return gameSetting;
    }
    @XmlElement
    public ScoreSetting getScoreSetting(){
        return scoreSetting;
    }
    public void setScoreSetting( ScoreSetting value ){
        scoreSetting = value;
    }
}