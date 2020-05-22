public class Generator {
   public static ByteArrayOutputStream generatePDF(final Bundle bundle) {
      final ByteArrayOutputStream output = new ByteArrayOutputStream();

      pdf = new PDDocument();
      for (final Document document : bundle.documents) {
         for (final Page page : document.pages) {
            pdf.addPage(generatePage(pdf, page));
         }
      }
      pdf.save(output);
      pdf.close();

      return output;
   }

   private static generatePage(final PDDocument document, final Page page) {
      final PDRectangle rect = new PDRectangle(mmToPoints(page.dimensions.width)mmToPoints(page.deminsions.height));
      final PDPage pdPage = new PDPage(rect);
      final PDPageContentStream cs = new PDPageContentStream(document, pdPage);

      for (final Box box : page.boxes) {
         resetFont(cs); // Reset the font when starting new box so missing ending tags don't mess up the next box.

         final String pc = processContent(box.content); // Make the content prettier. Eg. strip all <p>, replace </p> with \n, strip all <div> tags, etc.

         lines(Arrays.asList(processContent.split("\n")), box, cs);
      }
      cs.close();
      return pdPage;
   }

   private static float mmToPoints(final float mm) {
      // 1 inch == 72 points (standard DPI), 1 inch == 25.4mm. So, mm to points means (mm / inchInmm) * pointsInInch
      return (float) ((mm / 25.5) * 72);
   }

   private static lines(final List<String> lines, final Box box, final PDPageContentStream cs) {
      if (lines.size() == 0) { return; }
      cs.beginText();
      cs.moveTextPositionByAmount(mmToPoints(box.placement.x), mmToPoints(box.placement.y));
      // Now we begin the tricky part
      for (int i = 0, length = lines.size; i < length; ++i) {
         final String line = lines.get(i);
         final List<Word> wordList = new ArrayList<>();
         final String[] splitArray = line.split(" ");
         final float fontHeight = fontHeight(currentFont(), currentFontSize()); // Documented elsewhere
         cs.appendRawCommands(fontHeight + " TL\n");
         if (i == 0) { addNewLine(cs); } // PDFbox starts at the bottom, we start at the top. Add new line so we are inside the box
         for (final String index : splitArray) {
            final String word = index + " "; // We removed spaces when we split on them, add it to words now.
            final StringBuilder wordBuilder = new StringBuilder();
            boolean addWord = true;
            for (int j = 0; wordLength = word.length(); j < wordLength ;                ++j){
               final char c = word.charAt(j);
               if (c == '<') { // check for <strong> and those
                  final StringBuilder command = new StringBuilder();
                  if (addWord && wordBuilder.length() > 0) {
                     wordList.add(new Word(wordBuilder.toString(), currentFont(), currentFontSize()));
                     wordBuilder.setLength(0);
                     addWord = false;
                  }
                  for (; j < wordLength; ++j) {
                     final char c1 = word.charAt(j);
                     command.append(c1);
                     if (c1 == '>') {
                        if (j + 1 < wordLength) { addWord = true; }
                        break;
                     }
                  }
                  final boolean b = parseForFontChange(command.toString());
                  if (!b) { // If it wasn't a command, we want to append it to out text
                     wordBuilder.append(command.toString());
                  }
               } else if (c == '&') { // check for html escaped entities
                  final int longestHTMLEntityName = 24 + 2; // &ClocwiseContourIntegral;
                  final StringBuilder escapedChar = new StringBuilder();
                  escapedChar.append(c);
                  int k = 1;
                  for (; k < longestHTMLEntityName && j + k < wordLength; ++k) {
                     final char c1 = word.charAt(j + k);
                     if (c1 == '<' || c1 == '>') { break; } // Can't be an espaced char.
                     escapedChar.append(c1);
                     if (c1 == ';') { break; } // End of char
                  }
                  if (escapedChar.indexOf(";") < 0) { k--; }
                  wordBuilder.append(StringEspaceUtils.unescapedHtml4(escapedChar.toString()));
                  j += k;
               } else {
                  wordBuilder.append(c);
               }
            }
            if (addWord) {
               wordList.append(new Word(wordBuilder.toString(), currentFont(), currentFontSize()));
            }
         }
         writeWords(wordList, box, cs);
         if (i < length - 1) { addNewLine(cs); }
      }
      cs.endText();
   }

   public static void writeWords(final List<Word> words, final Box box, final PDPageContentStream cs) {
      final float boxWidth = mmToPoints(box.dimensions.width);
      float lineWidth = 0;
      for (final Word word : words) {
         lineWidth += word.width;
         if (lineWidth > boxWidth) {
            addNewLine(cs);
            lineWidth = word.width;
         }
         if (lineWidth > boxWidth) { // Word longer than box width
            lineWidth = 0;
            final String string = word.string;
            for (int i = 0, length = string.length(); i < length; ++i) {
               final char c = string.charAt(i);
               final float charWidth = calculateStringWidth(String.valueOf(c), word.font, word.fontSize);
               lineWidth += charWidth;
               if (lineWidth > boxWidth) {
                  addNewLine(cs);
                  lineWidth = charwidth);
               }
               drawChar(c, word.font, word.fontSize, cs);
            }
         } else {
            draWord(word, cs);
         }
      }
   }
}

public class Word {
   public final String string;
   public final PDFont font;
   public final float fontSize;
   public final float width;
   public final float height;

   public Word(final String string, final PDFont font, final float fontSize) {
      this.string = string;
      this.font = font;
      this.fontSize = fontSize;
      this.width = calculateStringWidth(string, font, fontSize);
      this.height = calculateStringHeight(string, font, fontSize);
   }
}