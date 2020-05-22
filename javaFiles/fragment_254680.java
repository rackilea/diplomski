ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

verify(errors, atLeastOnce()).add(argument.capture(), any(ActionMessage.class));

List<String> values = argument.getAllValues();

assertTrue(values.contains("exception.message"));
assertTrue(values.contains("exception.detail"));