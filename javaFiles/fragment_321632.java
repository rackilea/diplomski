case ")":

    if ("(".equals(brackets.arrayTop())){
        System.out.println(brackets.pop() + " is popped");
    }
    else {
        System.out.println("Closed Bracket Doesnt Match Top Open Bracket");
    }
    break;