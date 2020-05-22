String content = "1: <if(teams)>list: <teams;separator=\", \"><endif>";
ST template = new ST(content);

// Create a list with two items
List<Long> teams = new ArrayList<Long>();
teams.add(123L);
teams.add(124L);

template.add("teams", teams);

System.out.println(template.render());

// Add separator
System.out.println("--------");

content = "2: <if(teams)>list: <teams;separator=\", \"><endif>";
template = new ST(content);

// Create empty list
teams = new ArrayList<Long>();
template.add("teams", teams);

System.out.println(template.render());