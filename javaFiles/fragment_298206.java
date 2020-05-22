StringBuilder sb = new StringBuilder();
sb.append(type);
addStringParameter(sb, "filename", fileName);
addDateParameter(sb, "creation-date", creationDate);
addDateParameter(sb, "modification-date", modificationDate);
addDateParameter(sb, "read-date", readDate);
addLongParameter(sb, "size", size);
return sb;