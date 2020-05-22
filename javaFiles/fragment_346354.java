@Test
 public void doTest() throws FedoraClientException {
    connect();
    FindObjectsResponse response = null;

    response = findObjects().pid().title().query("title~foobar").execute(fedoraClient);
    List<String> pids = response.getPids();

    List<String> titles = new ArrayList<String>();
    for (String pid : pids) {
        titles.add(response.getObjectField(pid, "title").get(0));
    }
    assertEquals(7, titles.size());
  }