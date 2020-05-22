public  BackPropagation LoadFromXML(String FileName)throws 
     ParserConfigurationException, SAXException, IOException, ParseException 
    {
    BackPropagation myclass= new BackPropagation();
     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder parser = factory.newDocumentBuilder();
    File source = new File(FileName);
    Document doc = parser.parse(source);

    Node nodeNeuralNetwork = doc.getDocumentElement();
    if (!nodeNeuralNetwork.getNodeName().equals("neuralNetwork")) throw new ParseException("[Error] NN-Load: Parse error in XML file, neural network couldn't be loaded.",0);
    NodeList nodeNeuralNetworkContent = nodeNeuralNetwork.getChildNodes();
    System.out.print("<neuralNetwork>\n");
    for (int innc=0; innc<nodeNeuralNetworkContent.getLength(); innc++) 
    {
        Node nodeStructure = nodeNeuralNetworkContent.item(innc);
        if (nodeStructure.getNodeName().equals("structure")) 
        { 
            System.out.print("<stucture nuumberOfLayers = ");
            myclass.NumberOfLayers = Integer.parseInt(((Element)nodeStructure).getAttribute("numberOfLayers"));
            myclass.Layer  = new LAYER[myclass.NumberOfLayers];
            System.out.print(Integer.toString(myclass.NumberOfLayers)+">\n");
            NodeList nodeStructureContent = nodeStructure.getChildNodes();
             for (int isc=0; isc<nodeStructureContent.getLength();isc++)
             {
                 Node nodeLayer = nodeStructureContent.item(isc);

                 if (nodeLayer.getNodeName().equals("layer"))
                 {
                     int index = Integer.parseInt(((Element)nodeLayer).getAttribute("index"));
                     System.out.print("<layer index = "+Integer.toString(index)+" numberOfNeurons = ");
                     int number_of_N = Integer.parseInt(((Element)nodeLayer).getAttribute("numberOfNeurons"));
                     System.out.print(Integer.toString(number_of_N)+">\n");
                     if(index==0)
                     {
                         myclass.Layer[0]=new LAYER(number_of_N,800);

                     }
                     else
                     {
                         int j=index-1;
                         myclass.Layer[index]=new LAYER(number_of_N,myclass.Layer[j].Node.length);
                     }
                     NodeList nodeLayerContent = nodeLayer.getChildNodes();
                      for (int ilc=0; ilc<nodeLayerContent.getLength();ilc++)
                      {
                           Node nodeNeuron = nodeLayerContent.item(ilc);
                            if (nodeNeuron.getNodeName().equals("neuron"))
                            {
                                System.out.print("<neuron index = ");
                                int neuron_index = Integer.parseInt(((Element)nodeNeuron).getAttribute("index"));
                                myclass.Layer[index].Node[neuron_index].Threshold = Double.parseDouble(((Element)nodeNeuron).getAttribute("threshold"));
                                System.out.print(Integer.toString(neuron_index)+" threshold = "+Double.toString(myclass.Layer[index].Node[neuron_index].Threshold)+">\n");
                                NodeList nodeNeuronContent = nodeNeuron.getChildNodes();
                                  for (int inc=0; inc < nodeNeuronContent.getLength();inc++)
                                  {
                                      Node nodeNeuralInput = nodeNeuronContent.item(inc);                                    
                                      if (nodeNeuralInput.getNodeName().equals("input"))
                                      {
                                          System.out.print("<input index = ");
                                          int index_input = Integer.parseInt(((Element)nodeNeuralInput).getAttribute("index"));
                                          myclass.Layer[index].Node[neuron_index].Weight[index_input] = Double.parseDouble(((Element)nodeNeuralInput).getAttribute("weight"));
                                          System.out.print(Integer.toString(index_input)+" weight = "+Double.toString(myclass.Layer[index].Node[neuron_index].Weight[index_input])+">\n");
                                      }
                                  }
                            }
                      }


                 }
             }
             System.out.print("</structure");

        }
    }


   return myclass;
 }