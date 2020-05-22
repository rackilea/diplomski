> Map<String,String> subs = new HashMap<>();
> subs.put("{NAME}", "Alice");
> subs.put("{PLACE}", "Wonderland");
> ReplaceMap r = new ReplaceMap(subs.keySet());
> r.replace("Hello, {NAME} in {PLACE}.", subs)
"Hello, Alice in Wonderland." (String)