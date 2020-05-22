for (Project persist: projectList) { 
     persist.setProjectId("K7890");
     persist.setName(fileName);

      myDAO.saveProjects(projectList); 
 }

projectList.clear(); // <-- clear might cause to this Exception