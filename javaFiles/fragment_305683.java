String s = "OK";
if (result.equals(x)) {
    this.append("Equal Strings"); 
} else if (x.length() != result.length()) {
    this.append("Lengths are different");
} else if (x.charAt(0) != result.charAt(0)) {
    this.append("Character 0 different");
} else if (x.charAt(1) != result.charAt(1)) {
    this.append("Character 1 different");
} else {
    this.append("The universe is being swallowed by a giant squid");
}