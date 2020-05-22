String lastUsername = null;

while (rs.next) {
        String name = rs.getString(1);
        String username = rs.getString(2);
        String woSeclevel = rs.getString(3);
        String menu = rs.getString(6);
        String tab = rs.getString(7);
        String Desc = rs.getString(8);

        // when we change users (or if we haven't seen any user yet)
        // then output the header
        // if we have processed at least one user, then put space between
        // the last output and the new header
        if (lastUsername == null || ! lastUsername.equals(username)) {
            if (lastUsername != null) {
                bw.write("\n\n");
            }

            outputHeader(bw, name, username, woSeclevel);
        }
        outputLine(bw, menu, tab, Desc);

        // EDIT: this was wrong originally
        // we want to update the last seen username to be the username
        // of the current record; when the next record is retrieved, then
        // the comparison will output a new header if we have moved to
        // a different username. NOTE: assumes the records are properly
        // ordered
        lastUsername = username;
}