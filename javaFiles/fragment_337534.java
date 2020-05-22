if(checkList.size() > 0 && ids.size() > 0)
                {
                    Iterator<String> iterator = checkList.iterator();
                    while(iterator.hasNext()) {
                        String messageId = iterator.next();
                        System.out.println("dequeued message "+ messageId);
                        iterator.remove();
                    }
                }