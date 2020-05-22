Set<String> seen = ...
for(String arg: args) {
    if(seen.add(arg)) {
       // first time for this value of arg as its only added once.
    }
}