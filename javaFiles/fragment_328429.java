if(v.getID() == destination.getID()) {
                        System.out.println("Destination found");
                        Path path = new Path(previousVertex);
                        pathFound = Optional.of(path);
                        destinationFound = true;
                        break;
                    }