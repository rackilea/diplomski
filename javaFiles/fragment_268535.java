loop: while(!flag){
    //take user input here.
    case "John":
        display(12);  //passing value of n
        break loop;

    case "Jenny":
        display(6);
        break loop;
    default:
          System.out.print("Wrong Name");
}

private void display(int n) {
    System.out.println(n) ;
}