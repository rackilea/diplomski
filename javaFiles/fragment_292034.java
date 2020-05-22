for (Citation citation : citationIndex) {
            if (citation != null) {
                if (this.formatType.equals("IEEE")) {
                    System.out.println(citation.formatIEEE());
                } else if (this.formatType.equals("APA")) {
                    System.out.println(citation.formatAPA());
                } else if (this.formatType.equals("ACM")) {
                    System.out.println(citation.getAuthorsACM());
                }
            }
        }