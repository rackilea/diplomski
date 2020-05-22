// Prepare messages.
Map<String, String> messages = new HashMap<String, String>();
request.setAttribute("messages", messages);

// Get and validate name.
String name = request.getParameter("name");
if (name == null || name.trim().isEmpty()) {
    messages.put("name", "Please enter name");
} else if (!name.matches("\\p{Alnum}+")) {
    messages.put("name", "Please enter alphanumeric characters only");
}

// Get and validate age.
String age = request.getParameter("age");
if (age == null || age.trim().isEmpty()) {
    messages.put("age", "Please enter age");
} else if (!age.matches("\\d+")) {
    messages.put("age", "Please enter digits only");
}

// No validation errors? Do the business job!
if (messages.isEmpty()) {
    messages.put("success", String.format("Hello, your name is %s and your age is %s!", name, age));
}

request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);