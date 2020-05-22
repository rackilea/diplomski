public void SaveToXML(String FileName)throws     
       ParserConfigurationException,     FileNotFoundException,  
        TransformerException, TransformerConfigurationException
     {
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder parser = factory.newDocumentBuilder();
    Document doc = parser.newDocument();
    Element root = doc.createElement("neuralNetwork");
    Element layers = doc.createElement("structure");
    layers.setAttribute("numberOfLayers",Integer.toString(this.NumberOfLayers));
    for (int il=0; il<this.NumberOfLayers; il++){
        Element layer = doc.createElement("layer");
        layer.setAttribute("index",Integer.toString(il));
        layer.setAttribute("numberOfNeurons",Integer.toString(this.Layer[il].Node.length));
        if(il==0)
        {
            for(int in=0;in<this.Layer[il].Node.length;in++)
            {
                 Element neuron = doc.createElement("neuron");
                 neuron.setAttribute("index",Integer.toString(in));
                 neuron.setAttribute("NumberOfInputs",Integer.toString(1));
                 neuron.setAttribute("threshold",Double.toString(this.Layer[il].Node[in].Threshold));
                 Element input = doc.createElement("input");
                 double[] weights = this.Layer[il].Node[in].get_weights();
                 input.setAttribute("index",Integer.toString(in));
                input.setAttribute("weight",Double.toString(weights[in]));
                neuron.appendChild(input);
                layer.appendChild(neuron);
            }
            layers.appendChild(layer);

        }
        else
        {
         for (int in=0; in<this.Layer[il].Node.length;in++){
              Element neuron = doc.createElement("neuron");
            neuron.setAttribute("index",Integer.toString(in));
            neuron.setAttribute("NumberOfInputs",Integer.toString(this.Layer[il].Node[in].Weight.length));
            neuron.setAttribute("threshold",Double.toString(this.Layer[il].Node[in].Threshold));
            for (int ii=0; ii<this.Layer[il].Node[in].Weight.length;ii++) {
                 double[] weights = this.Layer[il].Node[in].get_weights();
                Element input = doc.createElement("input");
                input.setAttribute("index",Integer.toString(ii));
                input.setAttribute("weight",Double.toString(weights[ii]));
                 neuron.appendChild(input);                    
            }
            layer.appendChild(neuron);
            layers.appendChild(layer);
         }
    }
    }
    root.appendChild(layers);
    doc.appendChild(root);
    File xmlOutputFile = new File(FileName);
    FileOutputStream fos;
    Transformer transformer;
    fos = new FileOutputStream(xmlOutputFile);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(fos);
    transformer.setOutputProperty("encoding","iso-8859-2");
    transformer.setOutputProperty("indent","yes");
    transformer.transform(source, result);

    }