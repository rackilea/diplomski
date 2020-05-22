// Run a dummy Filter for correct initialization
Filter f = new Standardize();
f.setInputFormat(data);
Filter.useFilter(new Instances("", params, 0), f); // Dummy run on empty dataset
// Now run the MultiClassFLDA
f = new MultiClassFLDA();
f.setInputFormat(data);
data = Filter.useFilter(data, f);