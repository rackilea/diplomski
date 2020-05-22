String query = 
                "SELECT agent.familyname, agent.givenname"
                + " FROM agent"
                + " WHERE agent.agentid = ?"
                + " AND (" 
                + " LOWER(familyname) = ? OR LOWER(givenname) = ?" 
                + ") " 
                + " ORDER by familyname";


        pst.setInt(1, piececreation.agentid);
        pst.setString(2, agent_lastname.toLowerCase());
        pst.setString(3, agent_name.toLowerCase());