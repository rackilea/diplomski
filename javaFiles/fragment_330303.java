String[] regex = {"EVEN_BIN_NUM (0|1)*0", "ODD_BIN_NUM (0|1)*1", "PET (cat|dog)"} ;
String[][] split = new String[regex.length][];

for(int i = 0; i < regex.length; i++) {
  split[i] = regex[i].split(" ", 2);

}