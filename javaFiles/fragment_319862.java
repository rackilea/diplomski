package anotherTest;

    import java.util.List;

    import javax.xml.bind.annotation.XmlElement;
    import javax.xml.bind.annotation.XmlElementWrapper;
    import javax.xml.bind.annotation.XmlType;

    @XmlType(name = "Object")
    public class MyObject {

        private String challongeApiKey;

        @XmlElementWrapper(name = "players")
        private List<PlayerProfile> player;

        public String getChallongeApiKey() {
            return challongeApiKey;
        }

        public void setChallongeApiKey(String challongeApiKey) {
            this.challongeApiKey = challongeApiKey;
        }

        public List<PlayerProfile> getPlayer() {
            return player;
        }

        public void setPlayers(List<PlayerProfile> player) {
            this.player = player;
        }

    }