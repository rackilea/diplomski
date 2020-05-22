for (String mc: matchedContents){
        FileReader fr = new FileReader(FileDir);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(saveFileDir+String.valueOf(matchedContents.indexOf(mc)+1)+".xml", false);
        BufferedWriter bw = new BufferedWriter(fw);
        while ((s = br.readLine())!=null){
            // check if s has matched contents
            if (s.contains(mc)){
                String replacedString="";
                if (mc.contains("NV"))
                    replacedString = s.replace(mc, "NV("+anyItem(edgeNames)+")");
                else if (mc.contains("AW"))
                    replacedString = s.replace(mc, "AW("+anyItem(edgeNames)+")");
                bw.write(replacedString);
                bw.newLine();
            }
            else {
                bw.write(s);
                bw.newLine();
            }
        }
        System.out.println(mc+" end");
        bw.flush();
        bw.close();
        fw.close();
        br.close();
    }

    fr.close();