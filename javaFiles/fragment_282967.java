try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
    HelpFormatter f = new HelpFormatter();
    f.printHelp(pw, f.getWidth(), "myapp", null, options,
                f.getLeftPadding(), f.getDescPadding(), null, true);
    pw.flush();
    logger.info(sw.toString());
}