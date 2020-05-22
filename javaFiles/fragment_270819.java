while(line != null){

    for(int i=0; i<6; i++){
        str[i] = new String();
        line = input.readLine();
        str = line.split("[-]");
        x = Integer.parseInt(str[1]);
        y = Double.parseDouble(str[2]);
        Book a = new Book(str[0], x, y, str[3], str[4], str[5]);
        add(a);
    } 

}