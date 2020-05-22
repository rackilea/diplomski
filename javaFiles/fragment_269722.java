try (PreparedStatement st = con.prepareStatement(query)) {
        int n = 1;
        for (Object o : params) {

            if (o instanceof Character) {
                o = "" + o;
            }

            st.setObject(n, o);
            n++;
        }
        st.executeQuery();
    }