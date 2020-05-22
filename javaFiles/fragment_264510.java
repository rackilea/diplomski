for (String a : lines) // for all strings in the list:
        {   
            //System.out.println(a);
            if(names.contentEquals(a))  
            {
                hit = "Hit!";
                break;
            }else {
                hit = "*";              // no hit is * 
            }

        }