alert(m); // ["== 1", "=="]

var s = "Match at position " + m.index + ":\n";
for (i = 0; i < m.length; i++) {
  s = s + m[i] + "\n";
}
alert(s);