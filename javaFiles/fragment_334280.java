public class ResponseMessage {
                private boolean isLoginSuccess;
                private String errorMessage;

                // Getters and setters ...
            }

            // Servlet code 

            ResponseMessage message = new ResponseMessage();
            message.setError(true);
            message.setErrorMessage("Your error message");
            Gson gson = new Gson(); // GSON: library to convert Java object to JSON
            String content = gson.toJson(message);
            response.setContentType("text/json");
            response.getWriter().print(content);