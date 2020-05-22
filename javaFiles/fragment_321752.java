public void printList()
    {
            Scanner scan = new Scanner(System.in);
            Link currentLink = first;
            while(currentLink != null) {
                    currentLink.printLink();
                    currentLink = currentLink.nextLink;
                    scan.next();
            }
            System.out.println("");
    }