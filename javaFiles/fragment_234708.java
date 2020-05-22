else if (choice == 4) {
        Set<String> keySet = map.keySet(); //you should get keySet at here rather as your code for it maybe out date after 1 adding 
        int min = Integer.MAX_VALUE;// 
        String minName = null;///used to store the name of lowest
        for (String currentKey : keySet) {
            Student student = map.get(currentKey);
            int[] scores = student.getQuizGrades();

            for (int counter = 0; counter < scores.length; counter++) {//begin with 0 not 1 as your code
                if (scores[counter] < min) {
                    minName = currentKey;//store name
                    min = scores[counter];
                }
            } 
        } 
        System.out.println("The lowest quiz score was " + min + "his/her name is" + minName);
    }