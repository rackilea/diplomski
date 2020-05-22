private String Gh = ""; // no null but empty string by default

...

public String getGh {
  // If Gh is null or empty, assign "AAAAA"; empty otherwise
  Gh = (null == Gh || 0 == Gh.length()) 
    ? "AAAAA"
    : "";

  return Gh;
}

//TODO: Turn ShowGh() into camel case: showGh()
public String ShowGh() {
    //DONE: you probably mean "getGh()" instead of Gh
    // return ("Title: " + Gh);
    // getGh() tries to get Gh, change its value to "AAAAA" and we have "Title: AAAAA"
    return "Title: " + getGh();
}