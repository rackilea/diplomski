File file = null;
    FileInputStream fis = null;
    HWPFDocument document = null;
    Range commentRange = null;
    try {
        file = new File(fileName);
        fis = new FileInputStream(file);
        document = new HWPFDocument(fis);
        commentRange = document.getCommentsRange();
        int numComments = commentRange.numParagraphs();
        for (int i = 0; i < numComments; i++) {
            String comments = commentRange.getParagraph(i).text();
            comments = comments.replaceAll("\\cM?\r?\n", "").trim();
            if (!comments.equals("")) {
                System.out.println("comment :-  " + comments);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }