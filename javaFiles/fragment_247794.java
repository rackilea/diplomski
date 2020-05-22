// associated team list =================================================
    List<String> choices = new ArrayList<String>(); //init as List<String>
    for(int i=1;i<5;i++){
        for(Team team:getJtrac().findTeamGroup(i)){
            choices.add(team.getName()); //extract team names to List<String>
        }
    }
    pcrTeamz = new JtracCheckBoxMultipleChoice("pcrTeams", choices, new IChoiceRenderer() {
        public Object getDisplayValue(Object o) {
            return o;
        }
        public String getIdValue(Object o, int i) {
            return o.toString();
        }
    });
    add(pcrTeamz);