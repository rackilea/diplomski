@Override
public void updatePages(Set<Page> pages, Integer projectId) {
  Project project = entityManager.find(Project.class, projectId);
  for (Page p: pages) {
    p.setProject (project);
    //the pages are new? then also do em.persist(p) 
  }
 }