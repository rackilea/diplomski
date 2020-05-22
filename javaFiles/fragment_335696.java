private static final HashMap<String, CharPropertyFactory> map;

static CharProperty charPropertyFor(String name) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: getstatic     java/util/regex/Pattern$CharPropertyNames.map:Ljava/util/HashMap;
         * 3: aload_0
         * 4: invokevirtual java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
         * 7: checkcast     java/util/regex/Pattern$CharPropertyNames$CharPropertyFactory
         * 10: astore_1
         * 11: aload_1
         * 12: ifnonnull     19
         * 15: aconst_null
         * 16: goto          23
         * 19: aload_1
         * 20: invokevirtual java/util/regex/Pattern$CharPropertyNames$CharPropertyFactory.make:()Ljava/util/regex/Pattern$CharProperty;
         * 23: areturn
         *  */
        // </editor-fold>
    }