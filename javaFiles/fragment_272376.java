Iterator<Part> iterator = request.getParts().iterator();
       Part parts = null;
       while (iterator.hasNext()) {
       parts = (Part) iterator.next();
          //rest of the code block removed
       }
    }