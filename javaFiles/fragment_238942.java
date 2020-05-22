public static void main(String[] args) {

    int[] array_list = {3, 3, 3, 3, 3, 9, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8};
    int[] found_groups = new int[7];
    int group_size = 1; 
    int num_changed = 0; 
    for (int i = 1; i < array_list.length; i++) {

        if (array_list[i] == array_list[i-1]) {
            group_size++;

            if (group_size == 5) {
                found_groups[0] = group_size;
            }
            if (group_size == 3) {
                found_groups[2] = group_size; 
                found_groups[5] = group_size; 
            }
            if (group_size == 4) {
                found_groups[3] = group_size; 
            }
            if (group_size == 2) {
                found_groups[4] = group_size; 
            }
            if (group_size ==8) {
                found_groups[6] = group_size; 
            }
        }

        else if (array_list[i] != array_list[i-1]) {
            num_changed++;
            group_size = 1;
            if (group_size == 1) {
                found_groups[1] = group_size;
            }  
        }

    }

    int group_one = 0; 
    int group_two = 0; 
    int group_three = 0; 
    int group_four = 0; 
    int group_five = 0; 
    int group_six = 0; 
    int group_one_final = 0; 

    for (int i = 0; i < found_groups.length; i++) {
        if (found_groups[i] == 5) {
            group_five++; 
            group_two++;
            group_three++;
            group_four++;

        }
        if (found_groups[i] == 1) {
            group_one++; 
            group_one_final = group_one + num_changed; 
        }
        if (found_groups[i] == 3) {
            group_three++; 
            group_two++;
        }
        if (found_groups[i] == 4) {
            group_four++;
            group_two++;
            group_three++;

        }
        if (found_groups[i] == 8) {
            group_six++; 
            group_two++; 
            group_three++;
            group_four++;
            group_five++;
        }
        if (found_groups[i] == 2) {
            group_two++; 

        }
    }

    System.out.println("number of ones groups: " + group_one_final);
    System.out.println("number of two groups: " + group_two);
    System.out.println("number of three groups: " + group_three );
    System.out.println("number of fours groups: " + group_four);
    System.out.println("number of fives groups: " + group_five);
    System.out.println("number of sixes groups: " + group_six);
}