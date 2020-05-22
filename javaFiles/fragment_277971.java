String initial = "http://xxxxxx.com/songs2/Music%20Promotion/Stream/Action%20Manatee%20-%20Action.mp3";

String[] split = initial.split("/");

String output = split[split.length-1];

int length = output.lastIndexOf('.');
output = output.substring(0, length);
output = output.replace("%20", " ");