String inputText="";
    while (true) {
            System.out.println("enter");
            inputText = reader.nextLine();
            if(inputText.equals(""))
              break;
            else
              writer.write(inputText);
            writer.write("\n");
    }