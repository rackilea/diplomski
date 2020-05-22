pubnub.subscribe("Hell0 World", new Callback()
    {

        @Override
        public void successCallback(String arg0, Object arg1)
        {
            System.out.println(arg1);
        }
        //Adding the publish code into the connect callback.
        @Override
        public void connectCallback(String arg0, Object arg1)
        {
            pubnub.publish("Hello_World", "Hello World !", new Callback()
            {
                @Override
                public void successCallback(String arg0, Object arg1)
                {
                    System.out.println(arg1);
                }

                // here you should add an implementation of connectCallback :
                @Override
                public void connectCallback(String arg0, Object arg1)
                {
                    // some code
                }
            });


        }
    });