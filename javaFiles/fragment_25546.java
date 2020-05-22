String loc = ...
if (isWindows()) {
    //remove heading slash
    loc = loc.replaceAll("^/", "");
}
loc = URLDecoder.decode (loc, "UTF-8"); // this will replace all characters like "%20" with something like " "