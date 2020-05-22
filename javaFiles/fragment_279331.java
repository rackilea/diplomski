@Override
public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
        long arg3) {

    String Text = spinner.getSelectedItem().toString();

    if(Text.equals("list 1")) {    
        textSource = "path/to/textfile 1";    
    }       
    else if(Text.equals("list 2")){
        textSource = "path/to/textfile 2";    
    }    
    else {    
    }  

    // then put your URL code here as follows
    URL textUrl;
    String stringText = "";
    try {
        textUrl = new URL(textSource);
        BufferedReader bufferReader = new BufferedReader(
                new InputStreamReader(textUrl.openStream(), "ISO-8859-1"));
        //ISO-8859-1
        String StringBuffer;            

        while ((StringBuffer = bufferReader.readLine()) != null) {
            stringText += StringBuffer;    
        }

        bufferReader.close();  
        textMsg.setText(stringText);
        //textMsg.setText(string123);
    } catch (MalformedURLException e) {            
        e.printStackTrace();
        textMsg.setText(e.toString());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        textMsg.setText(e.toString());
    }   

 }