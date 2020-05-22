public String toString() {
           StringBuilder buffer = new StringBuilder();
           int i = 0;
           for(Location l = this; i < locations.length; l = locations[i++])
              if(filter.apply(l.id) { 
                 buffer.append("Location [location=" + Arrays.toString(location) + ", id=" + id
                    + ", description=" + description + ", weight=" + weight
                    + ", name=" + name + ", exit=" + Arrays.toString(exit)
                    +"]");
              }
           return buffer.toString();
         }