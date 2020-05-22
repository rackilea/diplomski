public String build(Message model) {
        model.setAttribute("Id", model.getId());

        List<user> users = model.getUsers();
        model.setAttribute("users", users);

        return "userTemplate";
    }