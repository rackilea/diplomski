myList.stream()
      .filter(m -> {
          try {
              return m.getClass()
                      .getMethod("setFont", new Class[] { Font.class }) != null;
          } catch (NoSuchMethodException | SecurityException e) {
              // log the exception
              return false;
          }
      })