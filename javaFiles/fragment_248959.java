static int differentTeams(String skills) {
    int numberOfTeams = Integer.MAX_VALUE;
    // Assign an array count of people in 5 Subjects
    int[] countArr = new int[5];
    for(int i=0;i<skills.length;i++){
       char subject = skills.charAt(i);
       if(subject=='p'){
            countArr[0]++;
       }else if(subject=='c'){
            countArr[1]++;
       }else if(subject=='m'){
            countArr[2]++;
       }else if(subject=='b'){
            countArr[3]++;
       }else if (subject=='z'){
            countArr[4]++;
       }else{ 
            throw new IllegalArgumentException("Invalid Input: " + subject); 
       }

    }
    // Iterate count array to find the Minimum Value
    for(int i=0;i<5;i++){
       if(countArr[i]<numberOfTeams){
          numberOfTeams = countArr[i];
       }
    }
    return numberOfTeams;
}