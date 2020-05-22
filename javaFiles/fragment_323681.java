Stack<Book> readingList = new Stack<>();



                            File myFile = new File("books.txt");
                            Scanner input = new Scanner(myFile);
                            int i = 0;
                            int counter = 0;
                            for (int numberOfBookToRead = 0; numberOfBookToRead < 2;numberOfBookToRead++) {
                                try {
                                    if(readingList.hasNextLine() && counter <= 4){ // provides that only 4 books are pushed while the iteration is going, and also works 
                                       readingList.push(new Book(input.nextLine(), input.nextLine()));
                                       counter += 1;
                                       System.out.println("Adding: " + readingList.lastElement().getInfo());
                                       readingList.push(new Book(input.nextLine(), input.nextLine()));
                                       counter +=1;
                                       System.out.println("Adding: " + readingList.lastElement().getInfo());
                                       System.out.println("Reading:  " + readingList.pop().getInfo());
                                       readingList.pop() = null;
                                    }catch(Exception e){
                                          e.printStackTrace();
                                     }
                                } else if(readingList.hasNextLine){
                                          readingList.push(new Book(input.nextLine(), input.nextLine()));
                                          System.out.println("Adding: " + readingList.lastElement().getInfo());
                                        }
                            }