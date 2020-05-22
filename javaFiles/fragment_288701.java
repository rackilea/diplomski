void import_cmd() throws NumberFormatException, ParseException {
    FileReader fr;
    BufferedReader br;
    String current;

    try {
        fr = new FileReader(cmd_path);
        br = new BufferedReader(fr);
    } catch (FileNotFoundException e) {
        if (this.controller != null) {
            controller.get_message("Error: file not found at this location "+cmd_path.getAbsolutePath());
        }
        return;
    }

    InputLine line;
    Set<Event> toAdd=new HashSet<Event>();

    try {
        current = br.readLine();
        while (current != null) {
            if (this.controller != null) {
                line = new InputLine(current, controller);
            } else {
                line = new InputLine(current);
            }
            if (line.cmd_check() == 1) {
                String extracted = line.getIn_line().substring(line.getIn_line().indexOf("(")+1, line.getIn_line().indexOf(")"));
                String path = this.event_path.getAbsolutePath()+File.separator+extracted;

                try {
                    toAdd=import_events(path);
                    if (this.controller != null) {
                        controller.get_message("File "+ extracted + " successfully imported ");
                    }
                } catch (FileNotFoundException e) {
                    if (this.controller != null) {
                        controller.get_message("Error: file not found at "+path);
                    }
                } catch (IOException ioe) {
                    if (this.controller != null) {
                        controller.get_message("Error: unable to read from file at "+path);
                    }
                }
                boolean addOk=EventSet.getInstance().add(toAdd);
                if (this.controller!=null) {
                    if (addOk) {
                        controller.get_message("Events added");
                    } else {
                        controller.get_message("No events to add");
                    }
                }
            } else if (line.cmd_check() == 2) {
                boolean valid = line.validate_date_iterval(line.getIn_line());
                if (valid) {
                    Date[] dates = line.convertIntervaltoDates(line.intervalExtract(line.getIn_line()));
                    createmap(dates[0], dates[1]);
                    if (this.controller != null) {
                        controller.get_message("Map correctly created for "+ line.getIn_line());
                    }
                } else if (this.controller != null) {
                    controller.get_message("Invalid date at "+ line.getIn_line()+": unable to create map");
                }

            }
            current = br.readLine();
        }
        br.close();
        fr.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}