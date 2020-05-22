for $id (@ID) {
    `java -Djava.util.Arrays.useLegacyMergeSort=true weka.classifiers.meta.FilteredClassifier -t $PATH/proteins/$id_MSA/$id_.arff -x $cv -s 0 -p 1,2 -distribution \
        -F "weka.filters.MultiFilter -F \" weka.filters.unsupervised.attribute.Remove -R 7,9\" -F \" weka.filters.unsupervised.attribute.RemoveType -T string\" \
        -F \"weka.filters.supervised.instance.SMOTE -C 0 -K 5 -P $smo -S 1\"" -W weka.classifiers.functions.MultilayerPerceptron -- -L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H 0 \
        > $PATH/rbfs/$id.rbf`;
}