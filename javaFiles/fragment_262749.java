boolean found = false;
        for(int x=0;x<SUBJECT.size();x++) {
            if(SB.equals(SUBJECT.get(x))) {
                System.out.println(SUBJECT.get(x)+"\t\t"+NAME.get(x)+"\t\t"+STUDNO.get(x)+"\t\t"+TIME.get(x));
found =true;
            }

        }
if(!found)
  System.out.println("No Record of "+SB+" Subject");