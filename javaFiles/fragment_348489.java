System.out.println("top of the reading");
    while((read = br.readLine()) != null){
        System.out.println("in reading");
        finale += read;
        output.setText(finale);
    }           
}
br.close();