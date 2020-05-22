for (int i = 1; i <= numberOfColumns; i++) {
        if (i > 1)
            System.out.print(",  ");
        if (rs.next()) // hope this works, not sure (but it does works for me at the click of a button, when used through Swing Events)
        {
            String columnValue = rs.getString(1);// Since only one thing is being returned by your rs object.
            name[i]=columnValue;
            System.out.println(name[i]);          //Everything executes well till here
        }
    }