public void append(String fragment) {
       char[] fragmentChars = fragment.toCharArray();
       char[] newData = new char[data.length + fragmentChars.length];

       System.arraycopy(data, 0, newData, 0, data.length);
       System.arraycopy(fragmentChars, 0, newData, data.length, fragmentChars.length);

       data = newData;
   }