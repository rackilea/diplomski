BufferedReader br = new BufferedReader(new FileReader(file));
     while((reader = br.readLine()) != null) {
         input = reader.split(",");
         DateRow row = new DateRow(
           input,
           df.parse(input[0])
         );
         dateList.add(row);
     }

     Collections.sort(dateList, new Comparator<DateRow>() {
          public int compare(DateRow o1, DateRow o2){
              return o1.getKey().compareTo(o2.getKey());
          }
     });

     for (DateRow row: dateList) {
         System.out.println(row.getData()[0] + "\t" + row.getData()[1]);
     }