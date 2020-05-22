package controller;

import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

public class SessionController {

    SessionController(){      
    }   

    public static JSONObject getLoggedUser(HttpSession session) {
        JSONObject storedUser = (JSONObject) session.getAttribute("user");
        return storedUser;
    }   

    public static JSONObject logUser(JSONObject object, HttpSession session) {
        //store user details
        session.setAttribute("user", object);
        JSONObject storedUser = (JSONObject) session.getAttribute("user");
        return storedUser;
    }

    public static JSONObject logOutUser(HttpSession session) {
        session.invalidate();
        return null;
    }
}