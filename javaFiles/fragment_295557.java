String in = "12X";

String out;

out  = in.contains("1") ? "1" : "-";
out += in.contains("2") ? "2" : "-";
out += in.contains("X") ? "X" : "-";