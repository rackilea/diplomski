@Override
      protected String doInBackground(NewChore1...chore) {
              HashMap<String, String> params1 = new HashMap<>();

              params1.put(Config.KEY_CHORE_TASK_TITLE, chore[0].title1);
              params1.put(Config.KEY_CHORE_DESCRIPTION, chore[0].description1);
              params1.put(Config.KEY_CHORE_PERSON,chore[0].person1);
              params1.put(Config.KEY_CHORE_MONDAY,chore[0].monday1);

              RequestHandler rh = new RequestHandler();
              String res = rh.sendPostRequest(Config.URL_ADD, params1);

              return res;
  }