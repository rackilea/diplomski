String query = "SELECT moduleId, moduleCode, module, professorIds from Course";
    PreparedStatement ps = null;
    Connection conn = null;
    ResultSet rs = null;

    // initialize the conn variable before execute the query
    // use a try block to handle exceptions properly

    ps = conn.prepareStatement(query);

    rs = ps.executeQuery();

    List<Course> courseList = new ArrayList<Course>();

    while (rs.next()) {

        Course course = null;

        List<String> professorIdsStrList = Arrays.asList(rs.getString("professorIds").split("\\s*,\\s*"));
        List<Integer> professorIdsIntList = professorIdsStrList.stream()
                         .map(s -> Integer.parseInt(s))
                         .collect(Collectors.toList());

        course = new Course(rs.getInt("moduleId"), rs.getString("moduleCode"), rs.getString("module"), professorIdsIntList);

        courseList.add(course);

    }