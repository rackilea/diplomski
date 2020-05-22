String[] formats = { "ab%cde%fg hij %klm n%op", "ab%c", "%d"
      };
      for (String f : formats) {
         String parsed = f.replaceAll("(^[a-z]+|(?<=%[a-z])([a-z ]+))", "'$1'");
         System.out.println(parsed);
      }