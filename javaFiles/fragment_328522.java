private static Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

Paragraph para= new Paragraph("YOUR CONTENT", bigfont);

Anchor anchor = new Anchor("sendMail");
anchor.setReference("mailto:"+email+"?subject=ReferenceNumber:1234");
para.add(anchor);