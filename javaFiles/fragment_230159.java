httpClient.newRequest("http://domain.com/path")
        .send(new Response.CompleteListener()
        {
            @Override
            public void onComplete(Result result)
            {
                // Your logic here
            }
        });