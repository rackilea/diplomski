package com.example.logging;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.slf4j.*;

public class App extends HttpServlet {

    private final Logger Logger = LoggerFactory.getLogger(App.class);
    Map<String, String> map = new HashMap<String, String>();

    public App() {
        map.put("user1", "Debug");
        map.put("user2", "Debug");
        map.put("user3", "Error");
    }

    public void writeToLogFile(String userName) {
        // if the user is in the map, we put it into ThreadConext for filtering
        if (map.containsKey(userName)) {
            MDC.put("level", map.get(userName));
        }

        Logger.error(userName + " error message");

        if (Logger.isDebugEnabled()) {
            Logger.debug(userName + " debug message");
        }

            // remember to remove it
        MDC.remove("level");
    }

}