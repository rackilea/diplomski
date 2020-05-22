jTreeVarSelectedPath = "";
    Object[] paths = jTreeDirectorios.getSelectionPath().getPath();
    for (int i=0; i<paths.length; i++) {
        jTreeVarSelectedPath += paths[i];
        if (i+1 <paths.length ) {
            jTreeVarSelectedPath += File.separator;
        }
    }