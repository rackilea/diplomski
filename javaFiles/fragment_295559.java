String in = "12X";

String out;

out  = ( in.contains("1") ? "1" : "-" )
     + ( in.contains("2") ? "2" : "-" )
     + ( in.contains("X") ? "X" : "-" );