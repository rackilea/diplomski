Set<String> currentSchools = new HashSet<>();
..
currentSchools.add(SchoolCode);
Logger.info("The list of Schools for " + f.getName() + " are: " + currentSchools);
numOfSchools = currentSchools.size();
Logger.info("The total count of Schools for " + f.getName() + " are: " + numOfSchools);        
uniqueSchools.addAll(currentSchools);