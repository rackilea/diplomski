String text = "22:44:55 <data quite much> data 2";
    text = text.replaceAll("(\\d{2}:\\d{2}:\\d{2}) <(.*)> (.*)", "replacement");
    System.out.println(text);
    text = "[22:44:55] <data quite much> data 2";
    text = text.replaceAll("(\\d{2}:\\d{2}:\\d{2}) <(.*)> (.*)", "replacement");
    System.out.println(text);