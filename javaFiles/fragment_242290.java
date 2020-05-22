Context context = response.getContext();
context.put(result_variable, "value from DB");
new MessageOptions.Builder("Your ID")
      .input(new InputData.Builder("Your response").build())
      .context(context) // setting context
      .build();