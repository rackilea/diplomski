String s ="Mivan is an aluminium formwork system developed by a European construction company. In 1990, the Mivan Company Ltd. from Malaysia started manufacturing these formwork systems. Today, more than 30,000sqm of formwork from Mivan Co. Ltd. \n" + 
            "\n" + 
            "Advantages:\n" + 
            "\n" + 
            "· More seismic resistance\n" + 
            "\n" + 
            "· Increased durability\n" + 
            "\n" + 
            "· Lesser number of joints and reduced leakages\n" + 
            "\n" + 
            "· Higher carpet area";
String comment = s.replaceAll("[\\n\\r]+", " ");
System.out.println(comment);