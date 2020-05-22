String[] options = new String[2];
       options[0] = "-R";                // "range"
       options[1] = "1";                 // first attribute

       weka.filters.unsupervised.attribute.StringToNominal ff=new weka.filters.unsupervised.attribute.StringToNominal(); // new instance of filter

       ff.setOptions(options);                           // set options
       ff.setInputFormat(data1);                          // inform filter about dataset **AFTER** setting options
       Instances data2 = Filter.useFilter(data1, ff);