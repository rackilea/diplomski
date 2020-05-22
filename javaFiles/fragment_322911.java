MapboxDirections client = new MapboxDirections.Builder()
                .setAccessToken(getString(R.string.accessToken))
                .setOrigin(origin)
                .setDestination(destination)
                .setProfile(DirectionsCriteria.PROFILE_DRIVING)
                .setAlternatives(true) // Gives you more then one route if alternative routes available
                .setSteps(true) // Gives you the steps for each direction
                .setInstructions(true) // Gives human readable instructions
                .build();