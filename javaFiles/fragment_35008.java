Set<String> colors = 
      new TreeSet<String>(new Comparator<String>()
          { 
            public int compare(String value1, String value2)
            {
              // this throw an exception if value1 is null!
              return value1.compareToIgnoreCase(value2);
            }
          });

colors.add("Red");
colors.add("Green");
colors.add("Blue");