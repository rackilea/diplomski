for (int i = 0; i < eventArray.size(); i++) {
     mTV.append("Id: " + String.valueOf(eventArray.get(i).id) + '\n' +
              "Title: " + eventArray.get(i).title + '\n' +
             "Description: " + eventArray.get(i).description + '\n');
 }

 display();