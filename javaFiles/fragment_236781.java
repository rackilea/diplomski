attInfo = FastVector();

attInfo.addElement(weka.core.Attribute('att1'));
attInfo.addElement(weka.core.Attribute('att2'));
attInfo.addElement(weka.core.Attribute('att3'));

% build the class attribute
classValues = FastVector();
classValues.addElement(java.lang.String('0'));
classValues.addElement(java.lang.String('1'));

attInfo.addElement(Attribute('Class', classValues));

% create the dataset and define the class attribute
dataset = Instances('relation', attInfo, 1);
dataset.setClassIndex(dataset.numAttributes() -1);

% build the instance
Inst = weka.core.Instance(10);
for ii = 1:D.numAttributes()
    Inst.setValue(D.attribute(ii-1), 1)
end
Inst.setDataset(dataset)

% classify the instance
classifier.classifyInstance(Inst)