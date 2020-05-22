public Foo resolveFoo(Map<String,String> input , DataFetchingEnvironment env){

        GraphQLContext context =  env.getContext();
        HttpServletRequest request = context.getHttpServletRequest().get();
        request.getHeader("content-type");
    }