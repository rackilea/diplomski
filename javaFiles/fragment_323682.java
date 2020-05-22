Stack<Book> readingList = new Stack<>();



                            File myFile = new File("books.txt");
                            Scanner input = new Scanner(myFile);
                            int i = 0;
                            int counter = 0;
                            int maxNumberOfBooks = 10; //could be any number you wish
                            for (int numberOfBookToRead = 0; numberOfBookToRead < Math.round(maxNumberOfBooks/2)-1;numberOfBookToRead++) {
                                try {
                                    if(readingList.hasNextLine() && counter <= maxNumberOfBooks-1){
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