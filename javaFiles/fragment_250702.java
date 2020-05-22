String[] commands = new String[] {"xelatex -synctex=1 -interaction=nonstopmode " + s + ".tex"
                                   , "del " + s + ".tex"};  
    Runtime r = Runtime.getRuntime();
    Process p;
    for (String command: commands) {
      p = r.exec(command);
      p.waitFor();
    }