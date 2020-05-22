String name = session.getAttribute("user").toString();
name = name.replace("\'", "''"); 

String query =   " SELECT DISTINCT t.text, t.user, t.date"
                + " FROM users u, tweets t, follows f" 
                + " Where t.parent is null"
                + " AND u.id = '"+name+"'"
                + " AND ( f.follower = u.id"
                + " AND f.followed = t.user"
                + " OR t.user = u.id)"
                + " ORDER BY t.date DESC";