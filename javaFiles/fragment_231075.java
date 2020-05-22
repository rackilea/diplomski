Chunk sigUnderline = new Chunk("                                            ");
    sigUnderline.setUnderline(0.1f, -2f);
    Chunk dateUnderline = new Chunk("                       ");
    dateUnderline.setUnderline(0.1f, -2f);

    Paragraph para = new Paragraph("Authorized Signature: ");
    para.add(sigUnderline);
    para.add(new Chunk(" Date: "));
    para.add(dateUnderline);

    document.add(para);