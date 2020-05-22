public List<String> getMatchingOptions(String opt) {
  opt = Util.stripLeadingHyphens(opt);
  List<String> matchingOpts = new ArrayList();
  if (this.longOpts.keySet().contains(opt)) {
    return Collections.singletonList(opt);
  } else {
    Iterator var3 = this.longOpts.keySet().iterator();

    while(var3.hasNext()) {
      String longOpt = (String)var3.next();
      /******************************************************/
      /* longOpt = "multiply"                               */
      /* opt = "multi"                                      */
      /******************************************************/
      if (longOpt.startsWith(opt)) {
        matchingOpts.add(longOpt);
      }
      /******************************************************/
    }

    return matchingOpts;
  }
}