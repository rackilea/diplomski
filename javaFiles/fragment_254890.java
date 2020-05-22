class Teams {

    Team team1 = new Team();
    Team team2 = new Team();

    @JsonAnySetter
    public void anySetter(String key, String value) {
        if (key.startsWith("team1")) {
            team1.setId(key);
            team1.setName(value);
        } else if (key.startsWith("team2")) {
            team2.setId(key);
            team2.setName(value);
        }
    }

    //getters, setterr, toString()
}