if(r!=null){
     for (int i = 0; i < r.length; i++) {
         JiraProjectDetails jiraProj = new JiraProjectDetails();
         jiraProj.setProjectID(r[i].getId());
         jiraProj.setProjectDesc(r[i].getDescription());
         jiraProj.setProjectKey(r[i].getKey());
         jiraProj.setProjectName(r[i].getName());
         jiraProj.setURL(r[i].getUrl());
         projlist.add(i,jiraProj);
         System.out.println("Jira Projects in loop: " + r[i].getName());
     }