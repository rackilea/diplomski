String data = "ABC   00 0 03 54            BTT";
    String[] tokens = data.split("\\s+");
    for(int i=0; i<tokens.length; i++){
        if(tokens[i].equals("BTT")){
           tokens[i] = tokens[i].replace("BTT"," ");
        }
    }
    data = Arrays.toString(tokens);
    Log.log(Log.VRB, "DEBUG: field =" + data);       

  StringBuffer b =new StringBuffer();
  for(int i = 0; i< tokens.length; i++)
  {
      b.append(tokens[i]);

      if(i< tokens.length -1)
      {
          b.append(" ");
      }
  }

  Log.log(Log.VRB, "DEBUG: field =" + b.toString());