int id = 3; 
int position = -1;
for (int i = 0; i < wordlist.size(); i++) {
    if (wordlist.get(i).getId() == id) {
        position = i;
        // break;  // uncomment to get the first instance
    }
}