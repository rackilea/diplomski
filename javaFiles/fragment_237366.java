public static void configure(String classpath) {

        Options.v().set_verbose(false);
        Options.v().set_keep_line_number(true);
        Options.v().set_src_prec(Options.src_prec_class);
        Options.v().set_soot_classpath(classpath);
        Options.v().set_prepend_classpath(true);

        PhaseOptions.v().setPhaseOption("bb", "off");
        PhaseOptions.v().setPhaseOption("tag.ln", "on");
        PhaseOptions.v().setPhaseOption("jj.a", "on");
        PhaseOptions.v().setPhaseOption("jj.ule", "on");

        Options.v().set_whole_program(true);
    }