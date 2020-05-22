System.out.println(sample1(i++)); // it's giving sample1() `i=0` then making `i=1` 
                                  //  so  sample1() will return 0 too;

System.out.println(sample1(++i)); // it's making `i=2` and then giving sample1() `i=2`
                                  // so sample1() will return 2;

System.out.println(sample2(j++)); // it's giving sample2() `j=0` then making `j=1` 
                                  // so sample2() will return 1;

System.out.println(sample2(++j)); // it's making `j=2` giving sample2() `j=2` then  
                                  // so sample2() will return 3;