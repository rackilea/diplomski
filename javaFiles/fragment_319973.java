XORNeuron[] layerLength = new XORNeuron[numNeurons];

    for(int neuCount = 0; neuCount < numNeurons; neuCount++) {
        layerLength[neuCount] = new XORNeuron();
        layerLength[neuCount].setNumInput(inpNum);
    }
}