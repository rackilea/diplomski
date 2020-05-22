String selectScore = "SELECT SCORES FROM STUDENTS";
ResultSet rs = st.executeQuery(selectScore);

....

float AllScores = rs.getFloat("SCORES");