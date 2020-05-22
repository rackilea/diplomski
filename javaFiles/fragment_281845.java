Pattern RegExPruefung = Pattern.compile(replacedRegex);

String sut = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
System.out.println(RegExPruefung.matcher(sut).matches());
sut = "abc⺠";
System.out.println(RegExPruefung.matcher(sut).matches());