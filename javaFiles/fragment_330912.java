while(bReader.readLine() != null)
      {
         line = bReader.readLine(); // read a second line
         double num = Double.parseDouble(line);
         sum = sum + num;
         count++;
      }