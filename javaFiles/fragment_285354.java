List<String> inputList = new ArrayList<String>();
    inputList.add("<b>SELL 512</b> lots of <b>xyz18@112.00</b>");
    inputList.add("<b>BUY 513</b> lots of <b>abc@113.00</b>");

    System.out.println("inputList: "+inputList);


    List<List<String>> Tuples = new ArrayList<List<String>>();
    List<String> list3 = new ArrayList<String>();
    List<String> list4 = new ArrayList<String>();
    List<String> list5 = new ArrayList<String>();
    List<String> list6 = new ArrayList<String>();

     for (int i = 0; i < inputList.size(); i++) {
           String var = inputList.get(i).trim();
           String[] splitArr=var.split("</b>|<b>|\\d*@"); //remove the \\d* if you expect to have xyz18 in output instead of x

           list3.add((splitArr[1].split("\\s"))[0]);
           list4.add((splitArr[1].split("\\s"))[1]);
           list5.add(splitArr[3]);
           list6.add(splitArr[4]);

           Tuples.add(Arrays.asList(var.replaceAll("</b>|<b>", "")));

       }
       System.out.println("Tuples: "+Tuples);
       System.out.println("list3: "+list3);
       System.out.println("list4: "+list4);
       System.out.println("list5: "+list5);
       System.out.println("list6: "+list6);