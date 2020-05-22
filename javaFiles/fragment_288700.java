private HashSet<Event> import_events(String path) throws FileNotFoundException, IOException, ParseException {     

    FileReader fr1;
    BufferedReader br1; 
    String current; 
    String[] tokens;
    HashSet<Event> set = new HashSet<Event>();

    fr1 = new FileReader(path);
    br1 = new BufferedReader(fr1); 
    current = br1.readLine(); 

    if (current == null) {
        if (this.controller != null) {
            controller.get_message("Warning: event file is empty, no events to import");
        }
        br1.close(); 
        fr1.close(); 
        return set; 
        }

    InputLine il;
    while (current != null) { 

        current = current.trim(); 

        if (this.controller != null) {
            il = new InputLine(current, controller);
        } else {
            il = new InputLine(current);
        }

        if (il.line_ok()) { 

            tokens = current.split(Pattern.quote(" "));

            RegState reg_state = RegState.valueOf(tokens[0]); 

            String user_id = tokens[3]; 

            LogState log_state = LogState.valueOf(tokens[1]);



            InputLine.d_format.setLenient(false); 
            Date timestamp = InputLine.d_format.parse(tokens[2]);


              String[] latlong = tokens[4].split(","); 
              double lat = Double.parseDouble(latlong[0]); 
              double longi = Double.parseDouble(latlong[1]); 
              Position pos = Position.create(lat, longi);

              if (pos == null) { 
                  if (this.controller != null) {
                      controller.get_message("Error: invalid coordinates at "+current+", event ignored");
                  }
                  break; 
              }

              Emotion emotion = Emotion.valueOf(tokens[5]);

              Event event = new Event(reg_state,log_state, timestamp, user_id, pos, emotion);

              set.add(event);
            }
            current = br1.readLine();
        }
        br1.close(); 
        fr1.close(); 
        return set; 
        }