ArrayList<String> lines;

/*
 * you add your lines to the 'lines' here somehow.
 */

String[][] arr = new String[lines.size()][];

for(int i = 0; i < lines.size(); i++) {
        arr[i] = lines.get(i).split("--", 2); 
        /* etc. */
}