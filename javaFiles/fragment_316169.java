String poem = "In software, a stack overflow [apple] occurs"
    + " when too much memory [orange] is used on the call stack [banana]."
    + " The call stack [pear] contains a limited amount of memory,"
    + " often determined at the start of the program [apple].";

Map<String, String> rep = new HashMap<String, String>();

rep.put("[apple]", "<img src='apple.jpg' />");
rep.put("[banana]", "<img src='banana.jpg' />");
rep.put("[orange]", "<img src='orange.jpg' />");
rep.put("[pear]", "<img src='pear.jpg' />");

for (Map.Entry<String, String> entry : rep.entrySet()) {
    poem = poem.replace(entry.getKey(), entry.getValue());
}

// poem now = what you want.