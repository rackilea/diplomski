o4=reader.nextInt();
            o5=reader.nextInt();
            o6=reader.nextInt();
            o7=reader.nextInt();
            o8=reader.nextInt();
            int sumhop2 = o4+o5+o6+o7+o8;
            int angrythug= 3 + (int)(Math.random()*85); 
            while(thugloop == true) {
                if(sumhop2>angrythug){
                     Thread.sleep(1000);
                     System.out.println("Woah, you are really good at this!");
                     System.out.println("But the thug is getting angrier. Put in 5 more numbers:");
                     o4=reader.nextInt();
                     o5=reader.nextInt();
                     o6=reader.nextInt();
                     o7=reader.nextInt();
                     o8=reader.nextInt();

                     sumhop2 = o5 + o5 + o7 + o8;
                     angrythug= 3 + (int)(Math.random()*85);
                     ...