rs = st.executeQuery("SELECT TITLE, YEAR FROM CD WHERE BAND_ID = " + i + ";");

// notice the name change below
Band band = new Band(name); // or, call this "b" to avoid name conflict

// Get the title of each CD for the current band
while (rs.next()) {
    band.addCD(
        new CD(rs.getString(1), Integer.parseInt(rs.getString(2))); // int year;
}

// Add a new band to the arraylist
bandList.add(band); // Added "List" to the name