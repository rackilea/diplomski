ArrayList<String> TableOfContent = new ArrayList<>();

        logTableOfContents(book.getTableOfContents().getTocReferences(), 0, TableOfContent);

        for (String string:TableOfContent){

            Toast.makeText(this, ""+ string, Toast.LENGTH_SHORT).show();

        }