Instance inst = new Instance(4); <-- Adjust number of instances you want to add.

        inst.setValue(trainData.attribute(0), age);
        inst.setValue(trainData.attribute(1), administrativeGenderCode);
        inst.setValue(trainData.attribute(2), zipCode);
        inst.setValue(trainData.attribute(3), race);
//      inst.setValue(trainData.attribute(4), "H2034"); <-- Do not add the instance you want to classify.