ArrayList<BuisnessObject> episodes;
        episodes = new ArrayList<BuisnessObject>();
        String url = "jdbc:mysql://localhost:3306/sons_of_anarchy";
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);          
        Connection connection = DriverManager.getConnection(url,"root","password");


        BuisnessObject newEpisode;

        // Takes the date from the form in String and converts it java.util.date which is how the buisness object is written
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rq.getParameter("origionalAirDate")); 

        // Creates an instance of the buisness object
        episodes.add(newEpisode = new BuisnessObject(Integer.parseInt(rq.getParameter("seasonNumber")), Integer.parseInt(rq.getParameter("seasonEpisodeNumber")), Integer.parseInt(rq.getParameter("seriesEpisodeNumber")), rq.getParameter("title"), rq.getParameter("directedBy"), rq.getParameter("writtenBy"), date, Float.parseFloat(rq.getParameter("viewingFigures"))));
        PreparedStatement editStatement = connection.prepareStatement("INSERT into episode_guide VALUES (null,?,?,?,?,?,?,?,?)");

        // Takes date from java.util.date and converts it to java.sql.date
        java.sql.Date mySqlDate = new java.sql.Date(newEpisode.origionalAirDate.getTime());


        editStatement.setInt(1, newEpisode.getSeasonNumber());
        editStatement.setInt(2, newEpisode.getSeasonEpisodeNumber());
        editStatement.setInt(3, newEpisode.getSeriesEpisodeNumber());
        editStatement.setString(4, newEpisode.getTitle());          
        editStatement.setString(5, newEpisode.getDirectedBy());
        editStatement.setString(6, newEpisode.getWrittenBy());
        editStatement.setDate(7, mySqlDate);
        editStatement.setFloat(8, (float) newEpisode.getViewingFigures());

        editStatement.executeUpdate();
        editStatement.close();
        connection.close();