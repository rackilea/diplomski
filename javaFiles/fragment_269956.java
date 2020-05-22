//I want the include searchResult.jsp
      request.getRequestDispatcher("/WEB-INF/views/searchResult.jsp").include(
              request, response);

      // cause the response to be sent to the client
      try {
          response.getOutputStream().close(); // if the OutputStream was used
      }
      catch(IllegalStateException e) {
          response.getWriter().close();       // if the Writer was used
      }

      //and then in backend for the below method to run
      Calculator.lookUp(Type, Place);

      }