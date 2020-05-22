public static void main(String[] args) throws IOException, DocumentException {
        Set<String> set = new ListUsedFonts().listFonts(PREFACE);
        PrintWriter out = new PrintWriter(new FileOutputStream(RESULT));
        for (String fontname : set)
            out.println(fontname);
        out.flush();
        out.close();
    }