File fichadas=new File("fichadas.xml");
if (fichadas.exists()){
     // append
     xmlOutput.output(doc, new FileWriter("fichadas.xml", true));
} else {
     // create 
     xmlOutput.output(doc, new FileWriter("fichadas.xml"));
}