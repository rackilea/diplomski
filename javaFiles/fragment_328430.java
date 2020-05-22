if(v.getID() == destination.getID()) {
                        System.out.println("Destination found");
                        destination.setPredecessor(actualVertex); // sets the predecessor for backwards traversal
                        Path path = new Path(previousVertex);
                        pathFound = Optional.of(path);
                        destinationFound = true;
                        break;
                    }