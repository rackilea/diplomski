D:\Temp :: chcp 1251
Aktive Codepage: 1251.
:: This is another codepage (8 bits only) that maps bytes to cyrillic characters.
:: Edit the source file to have:
::      PrintStream ps = new PrintStream(System.out, true, "Windows-1251");
:: We intend to match the console output; else we won't get the expected result.
D:\Temp :: javac -encoding utf-8 Kyrill.java && java Kyrill
12
??????? ????
Русский язык