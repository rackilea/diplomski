else if (i == randNum){
  System.out.println("You got it! Congrats! It took you " + tries +  " tries!");
  break;
} else if (i>randNum){
  System.out.println("Lower!");
}
i = sc.nextInt(); // <-- at the bottom of your for loop.