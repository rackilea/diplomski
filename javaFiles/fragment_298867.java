String latinText = "This is latin text";
String japaneseText = "これは日本語です";
String mixedText = "Tこhれiはs日 本i語sで すlatin text";

generatePdfFromStringImproved(latinText).writeTo(new FileOutputStream("Cccompany-Latin-Improved.pdf"));
generatePdfFromStringImproved(japaneseText).writeTo(new FileOutputStream("Cccompany-Japanese-Improved.pdf"));
generatePdfFromStringImproved(mixedText).writeTo(new FileOutputStream("Cccompany-Mixed-Improved.pdf"));