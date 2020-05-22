notes = notes
    .replace("!", "!!")
    .replace("%", "!%")
    .replace("_", "!_")
    .replace("[", "![");
PreparedStatement pstmt = con.prepareStatement(
        "SELECT * FROM analysis WHERE notes LIKE ? ESCAPE '!'");
pstmt.setString(1, notes + "%");