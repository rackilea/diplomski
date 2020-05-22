boolean found = false;
for(int i = 0; i < counter; ++i){

    if(records[i].str1.equals(name)){
        System.out.println("MATCH FOUND");
        found = true;
        break;
    }

}
if(!found) {
    System.out.println("NO MATCHES FOUND");
}