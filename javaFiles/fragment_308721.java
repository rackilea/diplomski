public void doGet(
        final HttpServletRequest request,
        final HttpServletResponse response)
  throws IOException {
    final PersistenceManager pm = PMF.get().getPersistenceManager();

    final List<ToDoListGaejdo> toDoLists;
    {
        final Query query = pm.newQuery(ToDoListGaejdo.class);
        query.setOrdering("listName asc");
        toDoLists = (List<ToDoListGaejdo>) query.execute();
    }

    final List<ToDoItemGaejdo> entries;
    {
        final Query query = pm.newQuery(ToDoItemGaejdo.class);
        query.setOrdering("listName asc, priority asc");
        entries = (List<ToDoItemGaejdo>) query.execute();
    }

    final ServletOutputStream out = response.getOutputStream();

    out.println("<head>");
    out.println("  <title>Debug View</title>");
    ....