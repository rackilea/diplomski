if (dataSnapshot.getValue() != null) {
        Map<String, Object> newPost = (Map<String, Object>) dataSnapshot.getValue();
        String ID_Question = newPost.keySet().toString().replace("[", "");
        ID_Question = ID_Question.replace("]", "");
        System.out.println("Id_question1: " + ID_Question);
        list_id_question.add(ID_Question);
    }