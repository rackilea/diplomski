new ProcessBuilder( new String[] {
  "bash",
  "--login",
  "-<some option>",
  "-c",
  "for arg in \"$@\"; do frobnicate \"$arg\" 42; done",
  "_",
  "first thing to frobnicate",
  "second thing", ...
}).start();