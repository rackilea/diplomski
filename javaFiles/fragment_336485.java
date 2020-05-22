Class cls;
Method getDescription;
String description;

cls = Class.forName(this.getPackageName() + ".SubGame" + subGameNo);
getDescription = cls.getMethod("getDescription");
description = getDescription.invoke(null);