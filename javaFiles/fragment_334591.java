for(int k = 0; k < 10; k++){
      System.out.println("Input Student name and grade: ");
      s = input.nextLine();
      String[] tempArray = s.split(" ");
      nameArray[k] = tempArray[0]; // store name to nameArray
      gradeArray[k] = Double.parseDouble(tempArray[1]);  // store grade to gradeArray
}