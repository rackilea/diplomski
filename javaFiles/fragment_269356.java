publish("1");
 publish("2", "3");
 publish("4", "5", "6");

might result in:
 process("1", "2", "3", "4", "5", "6")