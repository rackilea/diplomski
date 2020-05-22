MongoDbConnection conn = null;

        try {
            try {
                conn = new MongoDbConnection("mongodb://" + mongoHost + ":" + mongoPort + "/" + mongodb, null, null);
            } catch (JRException e) {
                System.out.println("JREException : " + e.getMessage());
            }