File f=new File("/tmp/test.txt");
    try (FileOutputStream fos=new FileOutputStream(f)){
        int id=1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        bw.write(String.valueOf(id)); //write player id
        bw.newLine();
        bw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    try (FileInputStream fis=new FileInputStream(f)){
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        String idstr=br.readLine();
        System.out.printf("readstr: '%s'\n",idstr);
        int id=Integer.parseInt(idstr);      // parse player id
        System.out.printf("parse id: '%d'\n",id);
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }