/////////Just to know it
        Log.e("lati", NastyLocationListener.getLatitude(this)); //On most phones you can use the Listener without any other Code
        Log.e("longi", NastyLocationListener.getLongitude(this)); //It uses Androids native cached location but this is not updated proper
        /////////Just to know it end

        /////////Normal usage
        nastyLocationListener = new NastyLocationListener(this); //In your MainActivity instanciate a NastyLocationListener (its only needed once... All other Activities could get data from him)
        nastyLocationListener.startListening(); //It starts listening to Location Updates and triggers the Location Provider to fetch updates (its bool, true if almost one Provider is available, false if no Provider is available)

        nastyLocationListener.stopListening(); //Use this line when you pause the app, or quit it... it will stop the listener and could be resumed with startListening()

        NastyLocationListener.getLatitude(this); //Could be used in every class, on every time, however you want without any other code like above
        NastyLocationListener.getLongitude(this); //Could be used in every class, on every time, however you want without any other code like above
        /////////Normal usage end