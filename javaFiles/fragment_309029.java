private static final Set forbiddenCopyHeaders = new HashSet<>(Arrays.asList(new String[]{
            "connection"
            , "transfer-encoding"
            , "content-length"
            , "via"
            , "x-forwarded-for"
            , "x-forwarded-host"
            , "x-forwarded-server"
    }));