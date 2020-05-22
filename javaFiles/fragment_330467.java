System.out.println(array2[b]
            + " --> This number of files that contain the term  "
            + numofDoc);
    double inverseTF = Math.log10((float) numDoc / numofDoc);
    System.out.println(array2[b] + " --> IDF " +  inverseTF );
    double TFIDF = (((double) wordCount / totalCount) * inverseTF );
    System.out.println(array2[b] + " --> TFIDF " + TFIDF);
}