else {
                HashMap<Long, Object> map = new HashMap<>();
                for(int i = 6; i < ArrayStr.length; i++)
                     //add items here

                  Unit unit = new Unit(ArrayStr[0], 
                                       ArrayStr[1], 
                                       Byte.parseByte(ArrayStr[2]), 
                                       ArrayStr[3], 
                                       ArrayStr[4], 
                                       Integer.parseInt(ArrayStr[5]), 
                                       map);
                   units.add(unit);
}