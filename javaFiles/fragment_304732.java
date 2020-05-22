if (str2.length() > 0) {
        if (localStringBuilder.length() > 0) {
          char c = localStringBuilder.charAt(localStringBuilder.length() - 1);
          if (c != '\\' && c != '/')
            localStringBuilder.append('\\');
        }
        localStringBuilder.append(str2);
      }