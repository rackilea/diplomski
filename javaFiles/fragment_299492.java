public String toString()
    // This version inserts commas between the technologies
    // It also generates the string efficiently, using a StringBuilder object.
    {
        StringBuilder returnVal = new StringBuilder("Programmer ");
        returnVal.append(super.toString());
        if (technologies.size() > 0)
        {
            returnVal.append(" and knows ");
          for(String technology:technologies){
              returnVal.append(technology).append(",");
          }
        }
        return returnVal.substring(0, returnVal.lastIndexOf(",")).toString();
    }