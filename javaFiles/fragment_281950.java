public String getBorrowed(){

        if(onLoan.isEmpty())
            return "No books borrowed";
        else{
            return onLoan.stream().map(b -> b.getTitle() + ", " + b.getAuthor()).collect(Collectors.joining("\n"));
        }
    }