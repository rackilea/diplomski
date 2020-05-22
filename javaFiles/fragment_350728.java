String original = "..content... <a href='document/link/B1'>foo</a> ...content... <a href='document/link/B2'>bar</a> ...";
   StringBuffer sb = new StringBuffer();
   // tweak the following
   Pattern pattern = Pattern.compile("(<a href='document/link/)([^']*)('>)");
   Matcher matcher = pattern.matcher(original);
   while(matcher.find()) {
      String oldlinkPart = matcher.group(2);
      String newlinkPart = buildNewLinkPart(oldLinkPart); // here you do your look-up
      matcher.appendReplacement(sb, matcher.group(1) + newlinkPart + matcher.group(3));
   }
   matcher.appendTail(sb);
   String modified = sb.toString();