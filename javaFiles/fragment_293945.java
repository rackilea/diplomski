for (Element divTag : divTags) {
        Elements aTags = divTag.getElementsByTag("a");

        aTags.stream()
                .filter(aTag -> aTag.child(0).attr("data-src").contains(".jp"))
                .forEach(aTag -> {
                    System.out.println(aTag.child(0).attr("data-src"));
                });

        aTags.stream()
                .filter(aTag -> aTag.child(0).attr("src").contains(".jp"))
                .forEach(aTag -> {
                    System.out.println(aTag.child(0).attr("src"));
                });
    }