for (int i = 0 ; i< this._featureNodes.getNumChildren(); ++i){

   if (_featureNodes.getChild(i).getNodeName().equals("figure"))
    {
        this._featureNodes.removeChild(i);  
    }
 }