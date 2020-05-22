String data = "Harry Potter 1 | J.K. Rowling| 350 | Fantasy | Hunger Games | Suzanne Collins | 500 | Fantasy | The KingKiller Chronicles | Patrick Rothfuss | 400 | Heroic Fantasy"; 
    String[] splitData = data.split("\\|");
    for(int i=0; i<splitData.length;i++) {
        if(i % 4 == 0) System.out.println("Title: "+splitData[i]);
        else if(i % 4 == 1) System.out.println("Author: "+splitData[i]);
        else if(i % 4 == 2) System.out.println("Pages: "+splitData[i]);
        else if(i % 4 == 3) System.out.println("Genre: "+splitData[i]);
    }