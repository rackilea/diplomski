// Percent split

int trainSize = (int) Math.round(inst.numInstances() * percent
    / 100);
int testSize = inst.numInstances() - trainSize;
Instances train = new Instances(inst, 0, trainSize);
Instances test = new Instances(inst, trainSize, testSize);