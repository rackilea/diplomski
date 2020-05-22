for(int i=0;i<questionList.getLength();i++)
    {
        Element question = (Element) questionList.item(i);
        String questionText = question.getAttribute("title");
        String tagText = question.getAttribute("tag");
        System.out.println("Question :"+questionText);
        System.out.println("tag :"+tagText);

        NodeList optionList = question.getElementsByTagName("option");
        for (int j = 0; j < optionList.getLength(); ++j)
        {
            Element option = (Element) optionList.item(j);
            String optionText = option.getFirstChild().getNodeValue();
            System.out.println("Option :"+optionText);
        }
    }