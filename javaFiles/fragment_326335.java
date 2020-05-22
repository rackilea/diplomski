private Map<String,String> ips; // Keys are jcbb values, values are ip your need
private JComboBox jcbb;

public UI(){
    initIPS(); // fill here your map data, don't forget to instanciate it as HashMap<>
    // Do some layouts putting...
    X.add(getJCBB(), BorderLayour.NORTH); // for example
}

public JComboBox getJCBB(){
    if(jcbb == null){
        jcbb = new JComboBox();
        //Add here data
    }
    return jcbb;
}

// Now here during your process buttin event
String ip = ips.get(getJCBB().getSelectedItem().toString()); // Acess to the ip pointed with the JCBB choice
//Process 
}