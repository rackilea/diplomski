String regEx = "(\\<input type\\=\"hidden\".*)(\"ip_h\"|\"lg_h\"|\"to\").*value\\=\"(.*?)\"";

Pattern pattern = Pattern.compile(regEx);
Matcher matcher = pattern.matcher(form);

// The required data ca be obtained from Group 3