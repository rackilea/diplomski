import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProgram {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Wrapper wrapper = mapper.readValue(new File("X:/json"), Wrapper.class);
        System.out.println(wrapper.getTeams());
    }
}

class Wrapper {

    private Teams teams;

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }
}