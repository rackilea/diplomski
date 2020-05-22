String s = "1-800-555-5678";
int dashes = s.split("-").length - 1;
if (dashes > 2) {
    System.out.print("error");
} else {
    // do something
}