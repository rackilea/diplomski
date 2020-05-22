if (!aired.equals("")) {
        list.add(new Episode(Long.parseLong(episodes.item(i)
                .getChildNodes().item(0).getTextContent()), Integer
                .parseInt(episodes.item(i).getChildNodes().item(10)
                        .getTextContent()), episodes.item(i)
                .getChildNodes().item(9).getTextContent(), episodes
                .item(i).getChildNodes().item(15).getTextContent(),
                Integer.parseInt(episodes.item(i).getChildNodes()
                        .item(19).getTextContent()), Integer
                        .parseInt(episodes.item(i).getChildNodes()
                                .item(28).getTextContent()), aired, 0));

    }