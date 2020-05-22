...
ResultSet rs = st.executeQuery(query);

ArrayList<String> names = new ArrayList<String>();
ArrayList<String> subjects = new ArrayList<String>();

while (rs.next()) { 
    names.add(rs.getString(1));
    subjects.add(rs.getString(2));
}

// finally turn the array lists into arrays - if really needed
String[] nameArr = new String[names.size()];
nameArr = names.toArray(nameArr);

String[] subjectArr = new String[subjects.size()];
subjectArr = subjects.toArray(subjectArr);