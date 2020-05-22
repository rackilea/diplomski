JVar helper = method
    .body()
    .decl(
        codeModel.ref(Helper.class),
        "helper",
        JExpr._new(codeModel.ref(Helper.class)));