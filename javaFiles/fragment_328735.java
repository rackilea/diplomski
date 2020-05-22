ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(UriBuilder.fromUri("http://localhost:8088/JerseyRest").build());   

        User u = new User();
        u.email = "xx@xx.com";
        u.ID = "sjdgzuauoj";
        u.Name = "user name";
        TestCase tc = new TestCase();
        tc.Href = "yyyy@hreg.com";
        tc.Method = "POST";
        tc.Rel = "link@link.com";

        Result[] rArr = new Result[]{ new Result(), new Result()};
        rArr[0].Href = "href@href.com";
        rArr[0].Method = "GET";
        rArr[0].Rel = "READ";

        rArr[1].Href = "href@href1.com";
        rArr[1].Method = "POST";
        rArr[1].Rel = "WRITE";
        RESULT_COLLECTION rCol = new RESULT_COLLECTION();

        rCol.Result = rArr;
        TAPattern req = new TAPattern();
        req.RESULT_COLLECTION = rCol;
        req.Car = "Volvo";
        req.Category = "0";
        req.Code = "1";
        req.Customizable_Field = "0";
        req.Description = "Test";
        req.status = "Y";
        req.Variant = "0";
        req.TestCase = tc;
        req.User = u;
        //GenericType<List<TAPattern>> taList = new GenericType<List<TAPattern>>() {};
        try{

        // Get XML for application   
       Response res = target.path("rest").path("UserService").path("xxxr").request()
                .accept(MediaType.APPLICATION_XML).post(Entity.entity(req, MediaType.APPLICATION_XML),Response.class);

        TAPattern ta = (TAPattern)res.readEntity(TAPattern.class);
       for(Result r : ta.RESULT_COLLECTION.Result ){
           System.out.println("Href: "+r.Href);
           System.out.println("Rel: "+r.Rel);
           System.out.println("Mehod: "+r.Method);
       }

    }catch(Exception e){
        System.out.println(e);
        return;
    }