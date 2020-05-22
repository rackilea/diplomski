for (int s = 0; s < stops; s++){
                    data = new String[5];
                    data[0] = bus_db[i];
                    data[1] = Integer.toString(j);
                    data[2] = prop.getProperty(bus_db[i] + "-bound" + j + "-stop" + s + "-stopcode");
                    data[3] = prop.getProperty(bus_db[i] + "-bound" + j + "-stop" + s + "-stopseq");
                    data[4] = prop.getProperty(bus_db[i] + "-bound" + j + "-stop" + s + "-stopname");
                    //Printing the building array
                    System.out.println(Arrays.deepToString(data));
                    busstop_pair.add(data);
                }