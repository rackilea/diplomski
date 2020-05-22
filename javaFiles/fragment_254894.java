import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProgram {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Wrapper wrapper = mapper.readValue(new File("X:/json"), Wrapper.class);
        System.out.println(wrapper.toTeams());
    }
}

class Wrapper {

    private LinkedHashMap<String, String> teams;

    public LinkedHashMap<String, String> getTeams() {
        return teams;
    }

    public void setTeams(LinkedHashMap<String, String> teams) {
        this.teams = teams;
    }

    public Teams toTeams() {
        List<Team> teamList = toTeamList();

        Teams result = new Teams();
        result.setTeam1(teamList.get(0));
        result.setTeam2(teamList.get(1));
        return result;
    }

    private List<Team> toTeamList() {
        List<Team> teamList = new ArrayList<Team>(teams.size());
        for (Entry<String, String> entry : teams.entrySet()) {
            Team team = new Team();
            team.setId(entry.getKey());
            team.setName(entry.getValue());
            teamList.add(team);
        }

        return teamList;
    }
}