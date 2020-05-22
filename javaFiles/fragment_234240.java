from(RouteA.getEndpoint()).routeId(RouteA.getEndpoint())
        .process(yourProcessor) 
        .choice()
            .when(header(flag).isEqualTo(true)).to(RouteB.getEndpoint())
        .end()
        .to(RouteC.getEndpoint())
        .to(RouteD.getEndpoint());