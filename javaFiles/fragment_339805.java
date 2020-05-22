private void logTableOfContents(List<TOCReference> tocReferences, int depth, ArrayList<String> ListOfContents) {

        if (tocReferences == null) {


            return;
        }

        for (TOCReference tocReference : tocReferences) {
            StringBuilder tocString = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                tocString.append("\t");
            }

            tocString.append(tocReference.getTitle());

            Log.v("TAG", tocString.toString());

            ListOfContents.add(tocString.toString());

            logTableOfContents(tocReference.getChildren(), depth + 1, ListOfContents);

            //return tocString.toString();

        }

    }