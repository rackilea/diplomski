Ranker ranker = new Ranker();
InfoGainAttributeEval ig = new InfoGainAttributeEval();
Instances instances = SamplesManager.asWekaInstances(trainSet);
ig.buildEvaluator(instances);
firstAttributes = ranker.search(ig,instances);
candidates = Arrays.copyOfRange(firstAttributes, 0, FIRST_SIZE_REDUCTION);
instances = reduceDimenstions(instances, candidates)
PrincipalComponents pca = new PrincipalComponents();
pca.setVarianceCovered(var);
ranker = new Ranker();
ranker.setNumToSelect(numFeatures);
selection = new AttributeSelection();
selection.setEvaluator(pca);
selection.setSearch(ranker);
selection.SelectAttributes(instances );
instances = selection.reduceDimensionality(wekaInstances);