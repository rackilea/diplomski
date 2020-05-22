public static void main(String[] args) {

        String jsonString = "[{\"question\":{\"questionId\":01,\"isActive\":1},\"tags\":[\"tag1\",\"tag2\"],\"choices\":[{\"choiceId\":0,\"questionId\":0},{\"choiceId\":1,\"questionId\":0}]}]";
        Gson gson = new Gson();

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(jsonString).getAsJsonArray();

        for (final JsonElement json : array) {
            Extracter jsonModel = gson.fromJson(json, new TypeToken<Extracter>() {
            }.getType());

            System.out.println(jsonModel.toString());

            List<Choices> choicesList = jsonModel.getChoices();
            //Looping the choices
            for (Choices choice :choicesList) {
                System.out.println("Choice :"  + choice);
                System.out.println("Choice Id :"  + choice.getChoiceId());
                System.out.println("Question Id :"  + choice.getQuestionId());
            }

            //Printing the question
            System.out.println("Question obj data :" + jsonModel.getQuestion());
            System.out.println("Course Id :" + jsonModel.getQuestion().getQuestionId());
            System.out.println("Active :" + jsonModel.getQuestion().getIsActive());

            //Printing the tags
            System.out.println(jsonModel.getTags());

        }

    }