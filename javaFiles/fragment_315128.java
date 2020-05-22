Map<String, Object> data = new HashMap<>();


    //================= Example Creating HeaderVo //=================

    HeaderVo header = new HeaderVo("la","la",5,5,"la","la");
    data.put("header", header);

    //================= Example Creating MiddleVo //=================

    MiddleVo middleVo = new MiddleVo("la","la",5,"la","la","la","la");
    data.put("middle", middleVo);

    //================= Example Creating internal items =================


    InternalVo v1 = new InternalVo(5, 5, 5, "s", true, "zz", "zzzz", "ll","EUR");
    InternalVo v2 = new InternalVo(5, 5, 5, "s", true, "zz", "zzzz", "ll","DOLLARS");
    InternalVo v3 = new InternalVo(5, 5, 5, "s", true, "zz", "zzzz", "ll","LAT");


    //List parsing 
    List<InternalVo> internalVos = new ArrayList<>();
    internalVos.add(v1);
    internalVos.add(v2);
    internalVos.add(v3);
    data.put("vos", internalVos);

    //================= //=================  //=================   //================= 


    final String message = this.templateManager.composeStringFromTemplate(data, "bankfile.ftl");