while ((sCurrentLine) != null)
    {
          if(sCurrentLine.contains("=") {                           
              config+=sCurrentLine.replace('=', ':');
              sCurrentLine = br.readLine()
              if(sCurrentLine!=null)
                  config+=",";
          }
    }