for (int i = 0; i < nodeList.getLength()
                    / constants.getParamColumns().length; i++) {
                for (int j = 0; j < constants.getParamColumns().length; j++) {

                    arr[i][j] = nodeList.item(
                            j + (i * constants.getParamColumns().length))
                            .getTextContent();

                }
            }