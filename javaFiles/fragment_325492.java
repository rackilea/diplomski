public String dumpWeightsVerbose() {
    final StringBuilder result = new StringBuilder();

    for (int layer = 0; layer < this.getLayerCount() - 1; layer++) {
        int bias = 0;
        if (this.isLayerBiased(layer)) {
            bias = 1;
        }

        for (int fromIdx = 0; fromIdx < this.getLayerNeuronCount(layer)
                + bias; fromIdx++) {
            for (int toIdx = 0; toIdx < this.getLayerNeuronCount(layer + 1); toIdx++) {
                String type1 = "", type2 = "";

                if (layer == 0) {
                    type1 = "I";
                    type2 = "H" + (layer) + ",";
                } else {
                    type1 = "H" + (layer - 1) + ",";
                    if (layer == (this.getLayerCount() - 2)) {
                        type2 = "O";
                    } else {
                        type2 = "H" + (layer) + ",";
                    }
                }

                if( bias ==1 && (fromIdx ==  this.getLayerNeuronCount(layer))) {
                    type1 = "bias";
                } else {
                    type1 = type1 + fromIdx;
                }

                result.append(type1 + "-->" + type2 + toIdx
                        + " : " + this.getWeight(layer, fromIdx, toIdx)
                        + "\n");
            }
        }
    }

    return result.toString();
}