Expression<String> countryName = builder().function(
                        "convertEncode", 
                        String.class,
                        join.get(Country_.NAME),
                        builder().literal("gbk")
                );

                return direction.isDescending() ? builder().desc(countryName ) : builder().asc(countryName );