for(int i = 1; i <= number; i++){
    pos = Integer.toString(i); // since it only changes once per line
    for (int j = 1; j < i; j++){
        System.out.print(pos + ","); // print without newline and with comma at the end
    }
    System.out.println(pos); // print one last time without comma and with newline
}