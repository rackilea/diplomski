public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        List<String> data = new ArrayList<>();
        data.add("name: meeting_name1");
        data.add("description: some_desc");
        data.add("07/18/2012 00:00:00");
        data.add("07/18/2012 00:00:00");
        data.add("name: meeting_name2");
        data.add("description: some_desc");
        data.add("07/18/2012 00:00:00");

        List<Meeting> result = new ArrayList<>();
        Meeting temp = null;
        for (String line : data) {
            if (line.startsWith("name:")) {
                temp = new Meeting(line.split(":")[1].trim());
                result.add(temp);
            } else if (line.startsWith("description:")) {
                temp.setDescription(line.split(":")[1].trim());
            } else {
                temp.getDates().add(simpleDateFormat.parse(line)); // Use date for
            }
        }
        System.out.println(result.get(0).getName() + ": " + result.get(0).getDates().size()); // meeting_name1: 2
        System.out.println(result.get(1).getName() + ": " + result.get(1).getDates().size()); // meeting_name2: 1    
    }

    static class Meeting {
        String name;
        String description;
        List<Date> dates;

        public String getName() {
            return name;
        }

        public List<Date> getDates() {
            return dates;
        }

        Meeting(String name) {
            this.name = name;
            this.dates = new ArrayList<>();
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }