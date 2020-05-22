MapboxDirections directions = MapboxDirections.builder()
                .accessToken(ACCESS_TOKEN)
                .profile(PROFILE_DRIVING)
                .overview(DirectionsCriteria.OVERVIEW_FULL) /** New line **/
                // Brooklyn, NY, USA
                .origin(Point.fromLngLat(-73.947803, 40.677790))
                // Upper West Side, NY, USA
                .destination(Point.fromLngLat(-73.971609, 40.784246))
                .build();