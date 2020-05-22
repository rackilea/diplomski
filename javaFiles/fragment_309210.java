String[] rij = new String[s.length()];

int j = 0; // To keep index in the array

for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) != ' ') { // When is not space, add character to 'temp'     
        temp += s.charAt(i);
    }
    else { // If it is space, add temp to array and reset 'temp'
        rij[j++] = temp;
        temp = "";
    }
}

rij[j] = temp; // Add last word

for (String s1: rij)
    if (s1 != null)
       System.out.println(s1);