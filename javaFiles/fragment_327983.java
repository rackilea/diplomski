Indicies.add(0);
            for (int i = 0; i < SPK.size() - 1; i++) {

                if (SPK.get(i) != SPK.get(i + 1)) {

                    Indicies.add(i + 1);

                }

            }
            for (int i = 0; i < Indicies.size() - 1; i++) {

                Count.add(Indicies.get(i + 1) - Indicies.get(i));
            }
            Count.add((SPK.size() - Indicies.get(Indicies.size() -   1)));

            System.out.println("count:" + Count);
            int counter = 0;
            int newIndex =0;
            for (int j = 1; j <= Count.size(); j++) {

                String element = "";


                for (int kk = 0; kk < (Count.get(j-1)); kk++) {
                    element = element + (DA.get(kk+newIndex) + SPK.get(kk+newIndex));
                }
                 newIndex = newIndex+Count.get(j-1);


                if (element.endsWith("A")){
                    SPKResource.add(element+"B");
                } else if (element.endsWith("B")){
                    SPKResource.add(element+"A");
                }

            }

        }

    }
    for (String S:SPKResource){
        System.out.println(SPKResource);

    }