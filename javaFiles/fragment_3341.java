<cfscript>

whitelist = createObject("java", "org.jsoup.safety.Whitelist");
collection = [];
tags = whitelist.getClass().getDeclaredField("tagNames");
tags.setAccessible(true);

// this portion uses the relaxed whitelist as an example
for (tag in tags.get(whitelist.relaxed()).toArray()) {
    arrayAppend(collection, tag.toString());
}

writeDump(collection);

</cfscript>