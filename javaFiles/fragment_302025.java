BufferedReader in = new BufferedReader(new FileReader(file_name));//replace file_name with your "User.txt"

String line_reader = null; // this is the string that reads each line

while((line_reader = in.readLine()) != null) // loop to add content to array list

  {
    file_content_list.add(line_reader);
  }